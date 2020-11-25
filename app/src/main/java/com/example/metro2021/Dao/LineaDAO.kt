package com.example.metro2021.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.example.metro2021.model.Linea
import com.example.metro2021.model.LineaView

@Dao
interface LineaDAO {

    @Query("SELECT id, nombre, color, eini, efin from\n" +
            "(select x.linea li, e1.nombre eini, e2.nombre efin from \n" +
            "(SELECT linea, min(id) mini, max(id) maxi from estacion group by linea) x, estacion e1, estacion e2 where mini=e1.id and maxi = e2.id) y, linea\n" +
            "where y.li= linea.id")
    fun getAllLineas(): LiveData<List<LineaView>>
}