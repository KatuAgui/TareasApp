package com.codingka.tareasapp.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.codingka.tareasapp.models.Tarea

@Dao
interface TareaDao {

    //insertar una tarea en mi bd
    @Insert
    suspend fun insertarTarea(tarea: Tarea)

    //Obtener todas las tareas(excluyendo las tareas eliminadas)   "eliminado" = false
    @Query("SELECT * FROM tareas WHERE eliminado = 0")
    suspend fun obtenerTodasLasTareas(): List<Tarea>

    //Eliminado suave  modificar eliminado =  true
    @Query("UPDATE tareas SET eliminado = 1 WHERE id=:tareaId")
    suspend fun eliminarSuave(tareaId: Long)

    @Query("SELECT * FROM tareas WHERE titulo LIKE:tituloTarea AND eliminado = 0")
    suspend fun buscarTarea(tituloTarea:String): List<Tarea>

    //Editar una tarea
    @Update
    suspend fun actualizarTarea(tarea: Tarea)//id

    //Eliminar una tarea permanente
    @Delete
    suspend fun eliminarPermanente(tarea: Tarea)
}


//organizar cuarto, hoy voy a organizar mi cuarto etc