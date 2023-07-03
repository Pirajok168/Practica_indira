package ru.android.practica_indira.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CarInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val brand: String,
    val model: String,
    val year: Int,
    val enginePower: Int,
    val engineVolume: Int,
    val fuel: String,
    val gearbox: String,
    val drive: String
)
