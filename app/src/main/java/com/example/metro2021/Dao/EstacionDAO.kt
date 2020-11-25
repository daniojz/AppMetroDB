package com.example.metro2021.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.metro2021.model.Estacion
import com.example.metro2021.model.EstacionView

@Dao
interface EstacionDAO {
    @Query("SELECT * from estacion where linea = :linea order by id ASC")
    fun getEstacionesByLinea(linea: Int): LiveData<List<EstacionView>>
}