package com.example.gmail

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.AdapterView
import kotlinx.android.synthetic.main.activity_recycler_view_bandeja.*

class RecyclerViewBandeja : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view_bandeja)

        val recyclerView = rv_bandeja_entrada
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
        lista.add(
            Mensaje(
                "Roberto",
                "Solicitud de amistad",
                "Roberto ha solicitado ser tu amigo en hi5."
            )
        )
        lista.add(
            Mensaje(
                "Paul",
                "Matriculas abiertas",
                "Te invitamos a formar parte de nuestro curso de verano. Ingresa al link para que puedas llenar un formulario y registrarte."
            )
        )
        lista.add(
            Mensaje(
                "Ignacio",
                "Pago de tarjeta",
                "Estimado Cristian.\n" +
                        "Usted registra una deuda pendiente acreditada a la tarjeta 213XXXXXXX12."
            )
        )
        iniciarRecyclerView(
            lista, actividad, recyclerView
        )

    }

    fun iniciarRecyclerView(lista: ArrayList<Mensaje>, actividad: RecyclerViewBandeja, recyclerView: RecyclerView) {
        val adaptadorPersona = AdaptadorMensaje(lista, actividad, recyclerView)
        rv_bandeja_entrada.adapter = adaptadorPersona
        rv_bandeja_entrada.itemAnimator = DefaultItemAnimator()
        rv_bandeja_entrada.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun irCorreo(mensaje: Mensaje) {
        val intent = Intent(
            this,
            Correo::class.java
        )
        intent.putExtra("mensaje", mensaje)
        startActivity(intent)
    }
}

