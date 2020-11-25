package com.example.metro2021.model

import android.app.Application
import androidx.lifecycle.LiveData

class LineaRepository (application: Application) {

    val lineaDAO = MetroDB.getDatabase(application)!!.lineaDAO()
    //select
    fun getAllLineas(): LiveData<List<LineaView>> {
        return lineaDAO.getAllLineas()
    }
}