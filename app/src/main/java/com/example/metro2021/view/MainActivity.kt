package com.example.metro2021.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.metro2021.R
import com.example.metro2021.Util.Util
import com.example.metro2021.adapter.CustomAdapterLineas
import com.example.metro2021.model.LineaView
import com.example.metro2021.viewModel.EstacionViewModel
import com.example.metro2021.viewModel.LineaViewModel
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var lineaViewModel: LineaViewModel
    private lateinit var estacionViewModel: EstacionViewModel
    private lateinit var lineas: List<LineaView>
    private lateinit var adapter: CustomAdapterLineas

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Util.inyecta(this, "MetroDB.db") //inyecta la base de datos al movil/app

        init()
    }

    private fun init(){
        estacionViewModel = ViewModelProvider(this).get(EstacionViewModel::class.java)
        getLineas()
    }

    private fun setAdapterLineas() {
        adapter = CustomAdapterLineas(this, this, R.layout.custom_card_linea, lineaViewModel)
        adapter.setLineas(lineas)
        rv_lineas.layoutManager = LinearLayoutManager(this)
        rv_lineas.adapter = adapter
    }

    private fun getLineas(){
        lineaViewModel = ViewModelProvider(this).get(LineaViewModel::class.java)
        lineaViewModel.getAllLineas().observe(this, Observer { lineas -> lineas?.let {
            this.lineas = it
            showLineas()
            setAdapterLineas()
        } })
    }

    private fun showLineas() {
        for (linea in lineas) {
            Log.d("app", linea.toString())
        }
    }

    fun onClickLinea(v: View){
        val linea:LineaView = v.tag as LineaView

        val intent = Intent(this,ActivityEstaciones::class.java)
        intent.putExtra("linea", linea)
        startActivity(intent)
    }
}