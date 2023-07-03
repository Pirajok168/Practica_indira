package ru.android.practica_indira.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(carInfoEntity: CarInfoEntity)
    @Delete
    suspend fun deleteItem(carInfoEntity: CarInfoEntity)
    @Query("SELECT * FROM CarInfoEntity")
    fun getAllItems() : Flow<CarInfoEntity>
}