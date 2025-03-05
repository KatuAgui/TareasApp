package com.codingka.tareasapp.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codingka.tareasapp.dao.CategoriaDao
import com.codingka.tareasapp.dao.TareaDao
import com.codingka.tareasapp.models.Categoria
import com.codingka.tareasapp.models.Tarea

@Database(entities = [Tarea::class, Categoria::class], version = 1)//exportSchema=false
abstract class TareaDatabase:RoomDatabase() {

    //Funciones Daos
    abstract fun tareaDao(): TareaDao
    abstract fun categoriaDao(): CategoriaDao

    //sigleton
    companion object{
        @Volatile  //actualizando los cambios en nuestra instacia de la bd
        private var INSTANCE: TareaDatabase? = null

        //fuuncion que obtenga la bd   OBTENER LA BD SIN CREAR
        fun getDatabase(context: Context): TareaDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    TareaDatabase::class.java,
                    "tarea_database"
                ).build()
                INSTANCE = instance
                instance
            }


        }
    }
}