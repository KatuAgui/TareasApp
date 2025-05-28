package com.codingka.tareasapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.codingka.tareasapp.models.Categoria
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.viewmodel.CategoriaViewModel
import com.codingka.tareasapp.viewmodel.TareaViewModel

@Composable
fun AgregarTarea(viewModel: TareaViewModel,categoriaViewModel: CategoriaViewModel ){
    //titulo
    var titulo by remember { mutableStateOf("") }
    //descripcion
    var descripcion by remember { mutableStateOf("") }
    //categorias
    var categoria by remember { mutableStateOf("") }

    var categoriaSeleccionadaId by remember { mutableStateOf<Long?>(null) }//0 Default
    //Alternativa de cargar datos del view model categorias
    val categorias by categoriaViewModel.categorias.observeAsState(initial = emptyList())
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        categoriaViewModel.cargarCategorias()
    }
    //Alternativa de cargar las categorias
//    var categorias by remember { mutableStateOf<List<Categoria>>(emptyList()) }
//    LaunchedEffect(Unit) {
//        categoriaViewModel.cargarCategorias() { lista ->
//                categorias = lista
//        }
//    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Nueva Tarea", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        //Titulo
        TextField(value = titulo,
            onValueChange = {
                titulo = it
            },
            label = { Text("Titulo") },
            modifier = Modifier.fillMaxWidth())

        //Descripcion
        TextField(value = descripcion,
            onValueChange = {
                descripcion = it
            },
            label = { Text("Descripcion") },
            modifier = Modifier.fillMaxWidth())

        //Categoria 1 Universidad  UNIVERSIDAD universidad univeRsidad
        //Lista plegable   Checkbot  vvv
//        TextField(value = categoria,
//            onValueChange = {
//                categoria = it
//                viewModel.buscarTarea(it)
//            },
//            label = { Text("Categoria") },
//            modifier = Modifier.fillMaxWidth())
        OutlinedTextField(
            value = categoriaSeleccionadaId.let{
                categorias.find { it.id == categoriaSeleccionadaId }?.titulo ?: "Seleccione una categoria"
            } ,
            onValueChange = {},
            label = {Text(text= "categoria")},
            modifier = Modifier.fillMaxWidth(),
            readOnly = true,
            trailingIcon = {
                IconButton(onClick = {expanded = !expanded}) {
                    Icon(imageVector = Icons.Default.ArrowDropDown)
                }
            }
        )
        DropdownMenu(
            expanded = expanded,//true = mostrar , false = no mostrar
            onDismissRequest = { expanded = false}
        ) {
            categorias.forEach { categoria ->
                DropdownMenuItem(
                    onClick = {
                        categoriaSeleccionadaId = categoria.id
                        expanded = false,
                    },
                ){
                    Text(categoria.titulo)
                }
            }
        }

        Button(onClick = {
            if(titulo.isNotBlank() && descripcion.isNotEmpty() && categoriaSeleccionadaId != null){
                val tarea = Tarea(0, titulo, descripcion, categoriaSeleccionadaId!!, false)
                viewModel.insertarTarea(tarea)

            }else{

            }
        }) { Text("Guardar Tarea") }
    }
}