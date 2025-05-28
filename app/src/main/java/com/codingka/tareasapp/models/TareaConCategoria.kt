package com.codingka.tareasapp.models

import androidx.room.Embedded
import androidx.room.Relation

data class TareaConCategoria(
    @Embedded val tarea: Tarea,
    @Relation(
        parentColumn = "categoria",
        entityColumn = "id"
    )
    val categoria: Categoria
)