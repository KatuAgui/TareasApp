package com.codingka.tareasapp.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.codingka.tareasapp.config.Screens
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.viewmodel.TareaViewModel


@Composable
fun ListaDeTareas(tareas: List<Tarea>, viewModel: TareaViewModel,  navController: NavController){

    if(tareas.isEmpty()){
        Text("NO HAY TAREAS DISPONIBLES",
            modifier = Modifier.padding(16.dp))
    }else{
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(tareas){tarea ->
                TareaItem(tarea, viewModel, navController)
            }
        }
    }
}

@Composable
fun TareaItem(tarea: Tarea,
              viewModel: TareaViewModel,
              navController: NavController
){
    var mostrarDialog by remember { mutableStateOf(false) }
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = tarea.titulo, style = MaterialTheme.typography.bodySmall)
            Text(text = tarea.descripcion, style = MaterialTheme.typography.labelLarge)
            Row(modifier = Modifier.padding(top = 8.dp)){
                Button(onClick = {
                    mostrarDialog = true
                }) { Text("Eliminar") }
                Button(onClick = {
                   //Redigigir
                    navController.navigate(Screens.EditarTarea.crearRuta(tarea.id))
                }) { Text("Editar") }
            }

        }
    }

    if(mostrarDialog){
        AlertDialog(
            title = { Text("Eliminar Tarea") },
            text = { Text("Estas seguro que quieres eliminar esta tarea_") },
            onDismissRequest = {mostrarDialog = false},
            confirmButton = {
                Button(onClick = {viewModel.eliminarTarea(tarea.id)
                    mostrarDialog = false
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Red))
                { Text("Si, Eliminar") }
            },
            dismissButton = {
                Button(onClick = {
                    mostrarDialog = false
                },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray))
                { Text("No, Eliminar") }
            }
        )
    }
}