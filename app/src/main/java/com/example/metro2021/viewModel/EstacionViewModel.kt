package com.example.metro2021.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.metro2021.model.Estacion
import com.example.metro2021.model.EstacionRepository
import com.example.metro2021.model.EstacionView

class EstacionViewModel (application: Application) : AndroidViewModel(application) {
    private var repository: EstacionRepository = EstacionRepository(application)

    fun getEstacionesByLiea(linea: Int): LiveData<List<EstacionView>> {
        return repository.getEstacionesByLinea(linea)
    }
}