package com.example.metro2021.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.metro2021.model.Linea
import com.example.metro2021.model.LineaRepository
import com.example.metro2021.model.LineaView

class LineaViewModel (application: Application) : AndroidViewModel(application)  {
    private var repository: LineaRepository = LineaRepository(application)

    fun getAllLineas(): LiveData<List<LineaView>> {
        return repository.getAllLineas()
    }
}