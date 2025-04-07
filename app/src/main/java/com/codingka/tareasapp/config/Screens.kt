package com.codingka.tareasapp.config

sealed class Screens(val route: String) {
    object TareasScreen : Screens("principal")
    object AgregarTarea : Screens("agregar_tareas")
    object EditarTarea : Screens("editar_tareas/{tareaId}"){
        fun crearRuta(tareaId:Long) = "editar_tareas/$tareaId"
    }
}