package com.example.metro2021.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.example.metro2021.model.LineaView
import com.example.metro2021.viewModel.LineaViewModel
import kotlinx.android.synthetic.main.custom_card_linea.view.*


class CustomAdapterLineas(val context: Context,
                          val lifecycle: LifecycleOwner,
                          val layout: Int,
                          val lineaViewModel: LineaViewModel
) : RecyclerView.Adapter<CustomAdapterLineas.ViewHolder>() {

    private var listLineas: List<LineaView> = emptyList()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewlayout = layoutInflater.inflate(layout, parent, false)
        return ViewHolder(viewlayout, context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemLinea = listLineas[position]

        holder.bind(itemLinea,lifecycle)
    }

    override fun getItemCount(): Int {
        return listLineas.size
    }

    internal fun setLineas(lineas: List<LineaView>) {
        this.listLineas = lineas
        notifyDataSetChanged()
    }

    class ViewHolder(viewlayout: View, val context: Context) : RecyclerView.ViewHolder(viewlayout) {


        fun bind(dataItemLinea: LineaView, lifecycle: LifecycleOwner){
            // itemview es el item de diseño
            // al que hay que poner los datos del objeto dataItem
                var idIcon = context.resources.getIdentifier("icono_linea_${dataItemLinea.id}.png", "drawable", context.packageName)
                itemView.card_iv_numeroLinea.setImageResource(idIcon)
                itemView.card_tv_Estaciones.text = "${dataItemLinea.eini} - ${dataItemLinea.efin}"
                itemView.card_tv_nombreLinea.text = dataItemLinea.nombre

                var CardView:CardView = itemView as CardView
                CardView.setCardBackgroundColor(Color.parseColor(dataItemLinea.color))
        }
    }
}