package com.example.metro2021.view

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metro2021.R
import com.example.metro2021.adapter.CustomAdaptereEstaciones
import com.example.metro2021.model.EstacionView
import com.example.metro2021.model.LineaView
import com.example.metro2021.viewModel.EstacionViewModel
import com.example.metro2021.viewModel.LineaViewModel
import kotlinx.android.synthetic.main.content_estaciones.*
import kotlinx.android.synthetic.main.content_main.*
import java.io.Serializable

class ActivityEstaciones : AppCompatActivity(), Serializable {

    private lateinit var estacionViewModel: EstacionViewModel
    private lateinit var estaciones: List<EstacionView>
    private lateinit var adapter: CustomAdaptereEstaciones
    private var linea: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_estaciones)
        init()
    }

    private fun init(){
        var linea = intent.getSerializableExtra("linea") as LineaView

        tv_nombreLinea.text = linea.nombre
        tv_nombreEstaciones.text = "${linea.eini} - ${linea.efin}"
        cl_linea.setBackgroundColor(Color.parseColor("${linea.color}50"))

        this.linea = linea.id //id de la linea sobra la que hemos hecho click

        estacionViewModel = ViewModelProvider(this).get(EstacionViewModel::class.java)
        getEstaciones()
    }
    
    private fun setAdapter(){
        adapter = CustomAdaptereEstaciones(this, this, R.layout.custom_card_estacion, estacionViewModel)
        adapter.setEstaciones(estaciones)
        rv_lineas.layoutManager = LinearLayoutManager(this)
        rv_estaciones.adapter = adapter

    }

    private fun getEstaciones(){
        estacionViewModel = ViewModelProvider(this).get(EstacionViewModel::class.java)
        estacionViewModel.getEstacionesByLiea(linea).observe(this, Observer { estaciones -> estaciones?.let {
            this.estaciones = it
            showEstaciones()
            setAdapter()
        } })
    }

    private fun showEstaciones() {
        for (linea in estaciones) {
            Log.d("app", "Estaciones------------------------------")
            Log.d("app", linea.toString())
        }
    }
}