package com.codingka.tareasapp.repository

import com.codingka.tareasapp.dao.TareaDao
import com.codingka.tareasapp.models.Tarea


//intermediario   entre   DAO    Y   VIEWMODEL
//Obtener los datos de una fuentes     ROOM       API EXTERNA      CACHE
class TareaRepository(private val tareaDao: TareaDao) {

    //FUNCIONES
    suspend fun insertarTarea(tarea: Tarea){
        tareaDao.insertarTarea(tarea)
    }

    suspend fun obtenerTareas(): List<Tarea>{
        return tareaDao.obtenerTodasLasTareas()
    }

    //Buscar
    suspend fun buscarTarea(titulo:String): List<Tarea>{
        return tareaDao.buscarTarea(titulo)
    }

    //eliminar soft delete
    suspend fun eliminarTarea(tareaId:Long){
        tareaDao.eliminarSuave(tareaId)
    }

    //editar
    suspend fun editarTarea(tarea:Tarea){
        tareaDao.actualizarTarea(tarea)
    }
}