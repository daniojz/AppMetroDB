package com.example.metro2021.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.metro2021.model.EstacionView
import com.example.metro2021.viewModel.EstacionViewModel
import kotlinx.android.synthetic.main.custom_card_estacion.view.*
import com.example.metro2021.R
import com.example.metro2021.model.Linea


class CustomAdaptereEstaciones(val context: Context,
                               val lifecycle: LifecycleOwner,
                               val layout: Int,
                               val estacionViewModel: EstacionViewModel
) : RecyclerView.Adapter<CustomAdaptereEstaciones.ViewHolder>() {

    private var listEstaciones: List<EstacionView> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemLinea = listEstaciones[position]

        holder.bind(itemLinea,lifecycle)
    }

    override fun getItemCount(): Int {
        return listEstaciones.size
    }

    internal fun setEstaciones(estaciones: List<EstacionView>) {
        this.listEstaciones = estaciones
        notifyDataSetChanged()
    }

    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {

        private var listCorrespondencias: List<Linea> = emptyList()

        fun bind(dataItemEstacion: EstacionView, lifecycle: LifecycleOwner){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem

            listCorrespondencias = dataItemEstacion.listCorrespondencias

            itemView.card_tv_nombreEstacion.text = dataItemEstacion.nombre.toString()

            var imagen = ImageView(context)
            imagen.setImageResource(R.drawable.icono_linea_1)
            itemView.ly_iconosLineas.addView(imagen)
        }
    }
}