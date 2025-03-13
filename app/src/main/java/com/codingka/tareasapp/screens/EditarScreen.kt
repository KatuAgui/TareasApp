package com.codingka.tareasapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.viewmodel.TareaViewModel


@Composable
fun EditarTarea(viewModel: TareaViewModel, tareaId: Long){

    val tareas by viewModel.tareas.observeAsState(initial = emptyList())
    val tareaAEditar = tareas.find { it.id == tareaId }

    if(tareaAEditar == null ){
        Text("Error tarea no encontrada")
        return
    }
    //titulo
    var titulo by remember { mutableStateOf(tareaAEditar?.titulo ?: "No se encontro el titulo") }
    //descripcion
    var descripcion by remember { mutableStateOf(tareaAEditar?.descripcion ?: "No se encontro la descripcion") }
    //categoria
    var categoria by remember { mutableStateOf(tareaAEditar?.categoria ?: "No se encontro la categoria") }


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

        //Categoria
        TextField(value = categoria,
            onValueChange = {
                categoria = it
                viewModel.buscarTarea(it)
            },
            label = { Text("Categoria") },
            modifier = Modifier.fillMaxWidth())

        Button(onClick = {
            if(titulo.isNotBlank() && descripcion.isNotEmpty() && categoria.isNotBlank()){
                val tarea = Tarea(tareaId, titulo, descripcion,categoria, false)
                viewModel.editarTarea(tarea)
            }else{

            }
        }) { Text("Editar Tarea") }
    }
}