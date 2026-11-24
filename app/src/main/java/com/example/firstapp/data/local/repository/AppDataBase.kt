package com.example.firstapp.data.local.repository

import android.content.Context
import androidx.room3.Database
import androidx.room3.Room
import androidx.room3.RoomDatabase
import com.example.firstapp.data.local.dao.UserDBDao
import com.example.firstapp.data.local.entities.UserDBEntity
import kotlin.concurrent.Volatile

@Database(entities = [UserDBEntity::class], version = 1)
abstract class AppDataBase : RoomDatabase() {

    abstract fun UserDBDao(): UserDBDao


    companion object {

        @Volatile
        private var INSTANCE: AppDataBase? = null

        fun getInstanceDB(context: Context): AppDataBase {

            if (INSTANCE == null) {
                val instance = Room.databaseBuilder(
                    context,
                    AppDataBase::class.java,
                    "mi_base_datos"
                ).build()
                INSTANCE = instance
            }
            return INSTANCE!!
        }
    }


}