package com.codingka.tareasapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.repository.TareaRepository
import kotlinx.coroutines.launch

//repositorio        view model       UI
class TareaViewModel(private val tareaRepository: TareaRepository): ViewModel() {

    val _tareas = MutableLiveData<List<Tarea>>()//vacio

    val tareas: LiveData<List<Tarea>> get() = _tareas//sin importar la accion todos los cambios se escucharan aqui


    //Funcion Obtener tareas
    fun obtenerTareas() {
        viewModelScope.launch {
            _tareas.value = tareaRepository.obtenerTareas()
        }
    }

    fun insertarTarea(tarea:Tarea){
        viewModelScope.launch {
            tareaRepository.insertarTarea(tarea)
            obtenerTareas()
        }
    }

    fun eliminarTarea(id:Long){
        viewModelScope.launch {
            tareaRepository.eliminarTarea(id)
            obtenerTareas()
        }
    }

    fun editarTarea(tarea:Tarea){
        viewModelScope.launch {
            tareaRepository.editarTarea(tarea)
            obtenerTareas()
        }
    }

    fun buscarTarea(titulo:String){
        viewModelScope.launch {
            _tareas.value = tareaRepository.buscarTarea(titulo)
        }
    }

}