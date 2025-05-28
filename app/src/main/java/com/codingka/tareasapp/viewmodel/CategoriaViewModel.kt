package com.codingka.tareasapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codingka.tareasapp.models.Tarea
import com.codingka.tareasapp.repository.CategoriaRepository
import com.codingka.tareasapp.repository.TareaRepository
import kotlinx.coroutines.launch


//repositorio        view model       UI
class CategoriaViewModel(private val categoriaRepository: CategoriaRepository): ViewModel() {

    val _categorias = MutableLiveData<List<Tarea>>()//vacio Base de datos   Funciones

    val categorias: LiveData<List<Tarea>> get() = _categorias//sin importar la accion todos los cambios se escucharan aqui

    //Funcion Obtener tareas
    fun cargarCategorias() {
        viewModelScope.launch {//corutina
            _categorias.value = categoriaRepository.cargarCategorias()
        }
    }

}