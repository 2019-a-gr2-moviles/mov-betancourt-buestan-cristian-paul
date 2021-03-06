package com.example.gmail

import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView

class AdaptadorMensaje(
    private val listaMensajes: List<Mensaje>,
    private val contexto: RecyclerViewBandeja,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorMensaje.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var remitenteTextView: TextView
        var inicialTextView: TextView
        var asuntoTextView: TextView
        var contenidoTextView: TextView

        init {
            remitenteTextView = view.findViewById(R.id.txt_remitente) as TextView
            inicialTextView = view.findViewById(R.id.txt_inicial) as TextView
            asuntoTextView = view.findViewById(R.id.txt_asunto) as TextView
            contenidoTextView = view.findViewById(R.id.txt_contenido) as TextView

            val layout = view.findViewById(R.id.linear_layout) as LinearLayout
            layout.setOnClickListener {
                val mensaje: Mensaje =
                    listaMensajes.find { msg -> msg.remitente == remitenteTextView.text.toString() } as Mensaje
                contexto.irCorreo(mensaje)
                remitenteTextView.setTextColor(Color.parseColor("#E4636363"))
                inicialTextView.setTextColor(Color.parseColor("#E4636363"))
                asuntoTextView.setTextColor(Color.parseColor("#E4636363"))
                contenidoTextView.setTextColor(Color.parseColor("#E4636363"))
                inicialTextView.setTextColor(Color.parseColor("#FFFFFFFF"))
                Log.i("recycler-view", mensaje.contenido)
            }

        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorMensaje.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaMensajes.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorMensaje.MyViewHolder, position: Int) {
        val mensaje = listaMensajes[position]
        myViewHolder.remitenteTextView.text = mensaje.remitente
        myViewHolder.asuntoTextView.text = mensaje.asunto
        myViewHolder.contenidoTextView.text = mensaje.contenido.substring(0, 20) + "..."
        myViewHolder.inicialTextView.text = mensaje.remitente.substring(0, 1)

    }
}