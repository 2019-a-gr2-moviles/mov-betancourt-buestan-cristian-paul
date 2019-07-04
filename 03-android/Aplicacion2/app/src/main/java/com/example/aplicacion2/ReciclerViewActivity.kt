package com.example.aplicacion2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recicler_view.*
import kotlinx.android.synthetic.main.layout.*
import kotlin.random.Random

class ReciclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recicler_view)

        val recyclerView = rv_personas
        val actividad = this
        val lista = arrayListOf<Persona>()

        lista.add(Persona("Cristian", "123485746"))
        lista.add(Persona("Paul, ", "879824154"))

        iniciarRecyclerView(lista, actividad, recyclerView)

    }

    fun iniciarRecyclerView(lista: ArrayList<Persona>, actividad: ReciclerViewActivity, recyclerView: androidx.recyclerview.widget.RecyclerView) {
        val adaptadorPersona = AdaptadorPersona(lista, actividad, recyclerView)
        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_personas.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(texto: String) {
        lbl_recyclerView.text = texto
    }

}
