package com.codingka.tareasapp.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.codingka.tareasapp.Greeting
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.ui.theme.TareasAppTheme
import com.codingka.tareasapp.viewmodel.TareaViewModel

//Pantalla principal
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TareasScreen(
    tareaViewModel: TareaViewModel
){
    //Escuchar los cambios   observar el estado
   val tareas by tareaViewModel.tareas.observeAsState(initial = emptyList())
    //Ejecutar el view model
    Scaffold(
        topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    "Lista de Tareas",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
        ) }) },
        floatingActionButton = { //Redireccion    Pantalla de agg tareas
            FloatingActionButton(
                onClick = {
                   //Redireccion
                },
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon( imageVector = Icons.Default.Add, contentDescription = "Agregar Tarea", tint = Color.White)
            }
        }
        ) { paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            //Buscar una tarea
            BuscarTarea(tareaViewModel)
            //Lista de tareas
            ListaDeTareas(tareas,tareaViewModel)
        }

    }
}

//Buscar una tarea
@Composable
fun BuscarTarea(
    viewModel: TareaViewModel
    ){
    var textoBusqueda by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = textoBusqueda,
            onValueChange = {
                textoBusqueda = it
                viewModel.buscarTarea(it)
            },
            label = { Text("Buscar Tarea") },
            modifier = Modifier.fillMaxWidth())
    }
}


@Preview(showBackground = true)
@Composable
fun BuscarPreview() {
    TareasAppTheme {
        val tarea = Tarea(1,"Titulo", "hola esta es una tarea", "Limpieza", true)
       // TareaItem(tarea)
    }
}