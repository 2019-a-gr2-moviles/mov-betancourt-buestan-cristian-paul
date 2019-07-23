package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import android.util.Log
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaMedicamentos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_medicamentos)

        var paciente: Paciente? = this.intent.getParcelableExtra<Paciente>("paciente")
        var medicamento: Medicamento? = this.intent.getParcelableExtra<Medicamento>("medicamento")
        var listaMedicamentosFiltrada: ArrayList<Medicamento> = arrayListOf<Medicamento>()

        if (paciente != null) {
            listaMedicamentosFiltrada = listaFiltrada(paciente.id)

        } else if (medicamento != null) {
            when (medicamento.opc) {
                0 -> {
                    medicamento.id = Datos.idMedicamento()
                    Datos.listaMedicamentos.add(medicamento)
                }
                1 -> {
                    val listaAux =
                        Datos.listaMedicamentos.filter { medicamentoAux -> medicamentoAux.id != medicamento.id }
                    Datos.listaMedicamentos = listaAux as ArrayList<Medicamento>
                }
                2 -> {
                    Datos.listaMedicamentos.map { medAux ->
                        if (medAux.id == medicamento.id) {
                            medAux.nombre = medicamento.nombre
                            medAux.gramosAIngerir = medicamento.gramosAIngerir
                            medAux.composicion = medicamento.composicion
                            medAux.fechaCaducidad = medicamento.fechaCaducidad
                            medAux.numeroPastillas = medicamento.numeroPastillas
                            medAux.pacienteId = medicamento.pacienteId
                            medAux.usadoPara = medicamento.usadoPara
                        }
                    }


                    Datos.listaMedicamentos.forEach { med ->
                        Log.i(
                            "###",
                            "${medicamento.nombre} ${medicamento.gramosAIngerir} ${medicamento.fechaCaducidad} ${medicamento.numeroPastillas}"
                        )
                    }
                }
                else -> {

                }
            }
            Log.i("idP@C", "${medicamento.pacienteId}")
            listaMedicamentosFiltrada =
                Datos.listaMedicamentos.filter { medAux -> medAux.pacienteId == medicamento.pacienteId } as ArrayList<Medicamento>
            Snackbar
                .make(lv_medicamentos, Datos.mensaje(medicamento.opc), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listaMedicamentosFiltrada)
        lv_medicamentos.adapter = adapter

        lv_medicamentos.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            listaMedicamentosFiltrada.forEach { med -> Log.i("idP@C", "${med.pacienteId}") }
            Log.i("ll", listaMedicamentosFiltrada[id.toInt()].toString())
            irGestionarMedicamento(listaMedicamentosFiltrada[id.toInt()])
        }
    }


    private fun listaFiltrada(id: Int): ArrayList<Medicamento> {
        return Datos.listaMedicamentos.filter { medicamento -> medicamento.pacienteId == id } as ArrayList<Medicamento>
    }

    private fun irGestionarMedicamento(medicamento: Medicamento) {
        val intent = Intent(
            this,
            GestionarMedicamento::class.java
        )

        intent.putExtra("medicamento", medicamento)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
