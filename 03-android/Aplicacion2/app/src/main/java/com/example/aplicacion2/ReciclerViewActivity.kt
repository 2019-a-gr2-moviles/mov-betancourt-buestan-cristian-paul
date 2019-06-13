package com.example.aplicacion2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutCompat
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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

    fun iniciarRecyclerView(lista: ArrayList<Persona>, actividad: ReciclerViewActivity, recyclerView: RecyclerView) {
        val adaptadorPersona = AdaptadorPersona(lista, actividad, recyclerView)
        rv_personas.adapter = adaptadorPersona
        rv_personas.itemAnimator = DefaultItemAnimator()
        rv_personas.layoutManager = LinearLayoutManager(actividad)

        adaptadorPersona.notifyDataSetChanged()
    }

    fun cambiarNombreTextView(texto: String) {
        lbl_recyclerView.text = texto
    }

}
