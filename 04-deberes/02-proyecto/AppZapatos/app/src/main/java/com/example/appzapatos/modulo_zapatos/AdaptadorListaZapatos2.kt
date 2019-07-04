package com.example.appzapatos.modulo_zapatos

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.appzapatos.R

class AdaptadorListaZapatos2(
    private val listaZapatos: ArrayList<Zapato>,
    private val contexto: ListaZapatos,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorListaZapatos2.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        var marcaTextView: TextView
//        var colorTextView: TextView
//        var tallaTextView: TextView
//        var tipoTextView: TextView
//        var cantidadTextView: TextView
//        var precioTextView: TextView
//        var eliminarBoton: Button


        init {
//            marcaTextView = view.findViewById(R.id.txt_mar_zap) as TextView
//            colorTextView = view.findViewById(R.id.txt_col_zap) as TextView
//            tallaTextView = view.findViewById(R.id.txt_tal_zap) as TextView
//            tipoTextView = view.findViewById(R.id.txt_tip_zap) as TextView
//            cantidadTextView = view.findViewById(R.id.txt_can_zap) as TextView
//            precioTextView = view.findViewById(R.id.txt_pre_zap) as TextView
//            eliminarBoton = view.findViewById(R.id.btn_eli_zap) as Button
//
//            val layout = view.findViewById(R.id.linear_layout_zap) as LinearLayout
//            layout.setOnClickListener {
//                Log.i("recycler-view", "Layout presionado")
//            }

        }
    }


    //Esta función define el template que vamos a utilizar.
    // El template esta en la carpeta de recursos res/layout -> layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaZapatos2.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_zapatos,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    //Devuelve el número de items de la lista
    override fun getItemCount(): Int {
        return listaZapatos.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaZapatos2.MyViewHolder, position: Int) {
//        val zapato: Zapato = listaZapatos[position]
//        myViewHolder.marcaTextView.text = zapato.marca
//        myViewHolder.colorTextView.text = zapato.color
//        myViewHolder.tipoTextView.text = zapato.tipo
//        myViewHolder.tallaTextView.text = zapato.talla.toString()
//        myViewHolder.cantidadTextView.text = zapato.cantidad.toString()
//        myViewHolder.precioTextView.text = zapato.precio.toString()
    }

}