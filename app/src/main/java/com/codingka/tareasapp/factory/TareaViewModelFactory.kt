package com.codingka.tareasapp.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codingka.tareasapp.repository.TareaRepository
import com.codingka.tareasapp.viewmodel.TareaViewModel

class TareaViewModelFactory(private val tareaRepository: TareaRepository): ViewModelProvider.Factory {
    override fun<T : ViewModel> create(modelClass: Class<T>): T{
        if(modelClass.isAssignableFrom(TareaViewModel::class.java)){
            return TareaViewModel(tareaRepository) as T
        }
        throw IllegalArgumentException("No se reconoce el View Model")
    }
}