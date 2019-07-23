package com.example.examen2b.actividades

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaMedicamentos
import com.example.examen2b.modelo.Medicamento
import com.example.examen2b.valoresEstaticos.Datos
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaMedicamentos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicamentos)
        val idPaciente = this.intent.getIntExtra("idPaciente", -1)
        iniciarRecyclerView(Datos.listaMedicamento, this, rv_medicamentos)

        btn_crear_medicamento.setOnClickListener {
            irCrearMedicamento()
        }
    }

    fun iniciarRecyclerView(
        listaMedicamentos: ArrayList<Medicamento>,
        actividad: ListaMedicamentos,
        recyclerView: RecyclerView
    ) {
        val adaptadorMedicamento = AdaptadorListaMedicamentos(listaMedicamentos, actividad, recyclerView)
        rv_medicamentos.adapter = adaptadorMedicamento
        rv_medicamentos.itemAnimator = DefaultItemAnimator()
        rv_medicamentos.layoutManager = LinearLayoutManager(actividad)

        adaptadorMedicamento.notifyDataSetChanged()
    }

    fun irCrearMedicamento() {
        val intent = Intent(
            this,
            CrearMedicamento::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }

}
