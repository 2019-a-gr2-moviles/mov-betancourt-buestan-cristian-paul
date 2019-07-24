package com.example.examen2b.actividades

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.examen2b.R
import com.example.examen2b.adaptador.AdaptadorListaMedicamentos
import com.example.examen2b.modelo.Medicamento
import com.example.examen2b.valoresEstaticos.Datos
import com.example.examen2b.valoresEstaticos.Servidor
import com.github.kittinunf.fuel.httpDelete
import com.github.kittinunf.result.Result
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*

class ListaMedicamentos : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicamentos)
        val idPaciente = this.intent.getIntExtra("idPaciente", -1)
        iniciarRecyclerView(Datos.listaMedicamento, this, rv_medicamentos)

    }

    fun iniciarRecyclerView(
        listaMedicamentos: ArrayList<Medicamento>,
        actividad: ListaMedicamentos,
        recyclerView: androidx.recyclerview.widget.RecyclerView
    ) {
        val adaptadorMedicamento = AdaptadorListaMedicamentos(listaMedicamentos, actividad, recyclerView)
        rv_medicamentos.adapter = adaptadorMedicamento
        rv_medicamentos.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        rv_medicamentos.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)

        adaptadorMedicamento.notifyDataSetChanged()
    }

    fun eliminarMedicamento(idMedicamento: Int) {
        val url = Servidor.url("medicamento") + "?id=${idMedicamento}"
        url.httpDelete()
            .responseString { request, response, result ->
                when (result) {
                    is Result.Failure -> {
                        val ex = result.getException()
                        Log.i("http", "Error: ${ex.message}")
                    }
                    is Result.Success -> {
                        runOnUiThread {
                            irListaPacientes()
                        }
                    }
                }
            }
    }

    fun irListaPacientes() {
        val intent = Intent(
            this,
            ListaPacientes::class.java
        )
        startActivity(intent)
    }


    fun irActualizarMedicamento(medicamento: Medicamento) {
        val intent = Intent(
            this,
            ActualizarMedicamento::class.java
        )
        intent.putExtra("id", medicamento.id)
        intent.putExtra("uso", "${medicamento.usadoPara}")
        intent.putExtra("gramos", medicamento.gramosAIngerir)
        intent.putExtra("composicion", "${medicamento.composicion}")
        intent.putExtra("nombre", "${medicamento.nombre}")
        intent.putExtra("fechaCaducidad", "${medicamento.fechaCaducidad}")
        intent.putExtra("pastillas", medicamento.numeroPastillas)
        startActivity(intent)
    }

}
