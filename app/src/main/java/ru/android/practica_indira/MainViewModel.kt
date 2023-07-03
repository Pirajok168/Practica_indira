package ru.android.practica_indira

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.CreationExtras
import ru.android.practica_indira.data.MainDB

class MainViewModel(dataBase: MainDB) : ViewModel() {

    companion object {
        val factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory{
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras): T {
                val dataBase = (checkNotNull(extras[APPLICATION_KEY]) as App).database
                return MainViewModel(dataBase) as T
            }
        }
    }
}