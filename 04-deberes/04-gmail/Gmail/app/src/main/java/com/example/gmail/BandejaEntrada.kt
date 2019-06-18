package com.example.gmail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_bandeja_entrada.*

class BandejaEntrada : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bandeja_entrada)

        val recyclerView = rv_bandeja
        val actividad = this
        val lista = arrayListOf<Mensaje>()

        lista.add(
            Mensaje(
                "Cristian",
                "Actualización de contraseña",
                "Su clave ha estado disponible por 3 meses. Es momento de cambiarla"
            )
        )
        lista.add(
            Mensaje(
                "José",
                "Factura electrónica",
                "Ingrese al siguiente link para descargar su factura: \nwww.misfacturas.com"
            )
        )
        iniciarRecyclerView(lista, actividad, recyclerView)
    }

    fun iniciarRecyclerView(lista: ArrayList<Mensaje>, actividad: BandejaEntrada, recyclerView: RecyclerView) {
        val adaptadorPersona = AdaptadorMensaje(lista, actividad, recyclerView)
        rv_bandeja.adapter = adaptadorPersona
        rv_bandeja.itemAnimator = DefaultItemAnimator()
        rv_bandeja.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }
}
