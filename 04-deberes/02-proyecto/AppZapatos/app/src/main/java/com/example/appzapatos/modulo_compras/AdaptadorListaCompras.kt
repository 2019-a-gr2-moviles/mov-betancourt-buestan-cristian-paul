package com.example.appzapatos.modulo_compras

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.appzapatos.R

class AdaptadorListaCompras(
    private val listaCompras: ArrayList<Compra>,
    private val contexto: ListaCompras,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorListaCompras.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var idTextView: TextView
        var nombreTextView: TextView
        var apellidoTextView: TextView
        var cedulaTextView: TextView
        var zapatoTextView: TextView
        var totalTextView: TextView
        var fechaTextView: TextView
        var validezTextView: TextView
        var anularBoton: Button

        init {
            idTextView = view.findViewById(R.id.txt_id_com) as TextView
            nombreTextView = view.findViewById(R.id.txt_nom_com) as TextView
            apellidoTextView = view.findViewById(R.id.txt_ape_com) as TextView
            cedulaTextView = view.findViewById(R.id.txt_ced_com) as TextView
            zapatoTextView = view.findViewById(R.id.txt_zap_com) as TextView
            totalTextView = view.findViewById(R.id.txt_tot_com) as TextView
            fechaTextView = view.findViewById(R.id.txt_fec_com) as TextView
            validezTextView = view.findViewById(R.id.txt_val_com) as TextView
            anularBoton = view.findViewById(R.id.btn_anu_com) as Button

            anularBoton.setOnClickListener {

                val compra = Compra(
                    idTextView.text.toString().toInt(),
                    null,
                    null,
                    null,
                    false,
                    null,
                    null
                )
                contexto.actualizarCompra(compra)
            }
        }
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaCompras.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_compras,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listaCompras.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaCompras.MyViewHolder, position: Int) {
        val compra: Compra = listaCompras[position]
        myViewHolder.idTextView.text = compra.id.toString()
        myViewHolder.nombreTextView.text = compra.codigoCli!!.nombre
        myViewHolder.apellidoTextView.text = compra.codigoCli!!.apellido
        myViewHolder.cedulaTextView.text = compra.codigoCli!!.cedula
        myViewHolder.fechaTextView.text = compra.fecha
        myViewHolder.zapatoTextView.text = "${compra.codigoZap!!.id} -> ${compra.codigoZap!!.cantidad}"
        myViewHolder.totalTextView.text = "TOTAL:   $${compra.total}"

        var validez = "No valida"

        if (compra.validez!!) {
            validez = "Valida"
            myViewHolder.anularBoton.visibility = View.VISIBLE
        } else {
            myViewHolder.anularBoton.visibility = View.INVISIBLE
        }
        myViewHolder.validezTextView.text = validez


    }
}
