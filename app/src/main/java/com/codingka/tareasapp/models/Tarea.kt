package com.codingka.tareasapp.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tareas")
data class Tarea(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "titulo") val titulo: String,
    @ColumnInfo(name = "descripcion") val descripcion: String,
    @ColumnInfo(name = "categoria") val categoria: String,
    @ColumnInfo(name = "eliminado") val eliminado: Boolean,//soft delete
)

//registro1    registro2   registro3