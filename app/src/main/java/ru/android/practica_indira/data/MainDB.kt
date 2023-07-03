package ru.android.practica_indira.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [CarInfoEntity::class],
    version = 1
)
abstract class MainDB : RoomDatabase() {

    companion object {
        fun createDataBase(context: Context) : MainDB {
            return Room.databaseBuilder(
                context,
                MainDB::class.java,
                "CarInfoDataBase",
            ).build()
        }
    }

}