package com.example.appzapatos.modulo_zapatos

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.example.appzapatos.R
import com.example.appzapatos.modulo_clientes.Cliente

class AdaptadorListaZapatos(
    private val listaZapatos: ArrayList<Zapato>,
    private val contexto: ListaZapatos,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorListaZapatos.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var idTextView: TextView
        var marcaTextView: TextView
        var colorTextView: TextView
        var tallaTextView: TextView
        var tipoTextView: TextView
        var cantidadTextView: TextView
        var precioTextView: TextView
        var eliminarBoton: Button


        init {
            idTextView = view.findViewById(R.id.txt_id_zap) as TextView
            marcaTextView = view.findViewById(R.id.txt_mar_zap) as TextView
            colorTextView = view.findViewById(R.id.txt_col_zap) as TextView
            tallaTextView = view.findViewById(R.id.txt_tal_zap) as TextView
            tipoTextView = view.findViewById(R.id.txt_tip_zap) as TextView
            cantidadTextView = view.findViewById(R.id.txt_can_zap) as TextView
            precioTextView = view.findViewById(R.id.txt_pre_zap) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eli_zap) as Button

            val layout = view.findViewById(R.id.lay_cam_zap) as LinearLayout
            layout.setOnClickListener {
                val zapato = crearZapato(
                    idTextView.text.toString().toInt(),
                    marcaTextView.text.toString(),
                    colorTextView.text.toString(),
                    tallaTextView.text.toString().toInt(),
                    tipoTextView.text.toString(),
                    cantidadTextView.text.toString().toInt(),
                    precioTextView.text.toString().toDouble()

                )
                contexto.irActulizarZapato(zapato)
            }

            eliminarBoton.setOnClickListener {

                val zapato = crearZapato(
                    idTextView.text.toString().toInt(),
                    marcaTextView.text.toString(),
                    colorTextView.text.toString(),
                    tallaTextView.text.toString().toInt(),
                    tipoTextView.text.toString(),
                    cantidadTextView.text.toString().toInt(),
                    precioTextView.text.toString().toDouble()

                )
                contexto.eliminarCliente(zapato)

            }

        }
    }


    //Esta función define el template que vamos a utilizar.
    // El template esta en la carpeta de recursos res/layout -> layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaZapatos.MyViewHolder {
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

    override fun onBindViewHolder(myViewHolder: AdaptadorListaZapatos.MyViewHolder, position: Int) {
        val zapato: Zapato = listaZapatos[position]
        myViewHolder.idTextView.text = zapato.id.toString()
        myViewHolder.marcaTextView.text = zapato.marca
        myViewHolder.colorTextView.text = zapato.color
        myViewHolder.colorTextView.setBackgroundColor(Color.parseColor(zapato.color));
        myViewHolder.colorTextView.setTextColor(Color.parseColor(zapato.color));
        myViewHolder.tipoTextView.text = zapato.tipo
        myViewHolder.tallaTextView.text = zapato.talla.toString()
        myViewHolder.cantidadTextView.text = zapato.cantidad.toString()
        myViewHolder.precioTextView.text = zapato.precio.toString()

//        listaZapatos.forEach { zapato ->
//            Log.i(
//                "http-zapato",
//                "${zapato.id} ${zapato.marca} ${zapato.color} ${zapato.talla} ${zapato.tipo} ${zapato.cantidad} ${zapato.precio}"
//            )
//        }
    }

    fun crearZapato(
        id: Int,
        marca: String,
        color: String,
        talla: Int,
        tipo: String,
        cantidad: Int,
        precio: Double
    ): Zapato {
        val zapato = Zapato(
            null,
            null,
            null,
            id,
            marca,
            color, talla, tipo, cantidad, precio
        )
        return zapato
    }
}