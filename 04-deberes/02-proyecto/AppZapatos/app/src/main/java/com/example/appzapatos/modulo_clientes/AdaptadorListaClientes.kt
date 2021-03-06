package com.example.aplicacion2

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
import com.example.appzapatos.modulo_clientes.ListaClientes

class AdaptadorListaClientes(
    private val listaClientes: ArrayList<Cliente>,
    private val contexto: ListaClientes,
    private val recyclerView: RecyclerView
) :
    RecyclerView.Adapter<AdaptadorListaClientes.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var nombreTextView: TextView
        var apellidoTextView: TextView
        var cedulaTextView: TextView
        var idTextView: TextView
        var eliminarBoton: Button

        init {
            nombreTextView = view.findViewById(R.id.txt_nom_cli) as TextView
            apellidoTextView = view.findViewById(R.id.txt_ape_cli) as TextView
            cedulaTextView = view.findViewById(R.id.txt_ced_cli) as TextView
            idTextView = view.findViewById(R.id.txt_id_cli) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eli_cli) as Button

            val layout = view.findViewById(R.id.lay_cam_cli) as LinearLayout
            layout.setOnClickListener {
                val cliente = crearCliente(
                    idTextView.text.toString().toInt(),
                    nombreTextView.text.toString(),
                    apellidoTextView.text.toString(),
                    cedulaTextView.text.toString()
                )
                contexto.irActulizarCliente(cliente)

            }

            eliminarBoton.setOnClickListener {
                val cliente = crearCliente(
                    idTextView.text.toString().toInt(),
                    nombreTextView.text.toString(),
                    apellidoTextView.text.toString(),
                    cedulaTextView.text.toString()
                )
                contexto.eliminarCliente(cliente)

            }
        }

    }

    //Esta función define el template que vamos a utilizar.
    // El template esta en la carpeta de recursos res/layout -> layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaClientes.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_clientes,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    //Devuelve el número de items de la lista
    override fun getItemCount(): Int {
        return listaClientes.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaClientes.MyViewHolder, position: Int) {
        val cliente: Cliente = listaClientes[position]
        myViewHolder.nombreTextView.text = cliente.nombre
        myViewHolder.apellidoTextView.text = cliente.apellido
        myViewHolder.cedulaTextView.text = cliente.cedula
        myViewHolder.idTextView.text = cliente.id.toString()

    }

    fun crearCliente(id: Int, nombre: String, apellido: String, cedula: String): Cliente {
        val cliente = Cliente(
//            null,
            null,
            null,
            id,
            nombre,
            apellido,
            cedula
        )
        return cliente
    }
}