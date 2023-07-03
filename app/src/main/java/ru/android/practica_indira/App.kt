package ru.android.practica_indira

import android.app.Application
import ru.android.practica_indira.data.MainDB

class App : Application() {
    val database by lazy { MainDB.createDataBase(this) }
}