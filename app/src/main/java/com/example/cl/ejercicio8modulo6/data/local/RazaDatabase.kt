package com.example.cl.ejercicio8modulo6.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RazaEntity::class], version = 1)
abstract class RazaDatabase:RoomDatabase() {

    abstract fun getRazaDao():RazaDao

    companion object{
        @Volatile
        private var INSTANCE: RazaDatabase?= null

        fun getDataBase(context: Context): RazaDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RazaDatabase::class.java,
                    "razas_database"
                ).build()

                INSTANCE = instance
                return instance

            }
        }
    }
}