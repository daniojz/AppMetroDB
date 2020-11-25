package com.example.metro2021.model

import android.app.Application
import androidx.lifecycle.LiveData

class EstacionRepository(application: Application) {
    val EstacionDAO = MetroDB.getDatabase(application).estacionDAO()
    //select
    fun getEstacionesByLinea(linea: Int): LiveData<List<Estacion>> {
        return EstacionDAO.getEstacionesByLinea(linea)
    }
}