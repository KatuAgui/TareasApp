package com.codingka.tareasapp.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.codingka.tareasapp.models.Categoria

@Dao
interface CategoriaDao {
    @Insert
    suspend fun insertarCategoria(categoria: Categoria)

    @Query("SELECT * FROM categorias")
    suspend fun obtenerCategorias(): List<Categoria>

    @Query("SELECT * FROM categorias WHERE id=:idCategoria")
    suspend fun obtenerId(idCategoria:Long): Categoria
}