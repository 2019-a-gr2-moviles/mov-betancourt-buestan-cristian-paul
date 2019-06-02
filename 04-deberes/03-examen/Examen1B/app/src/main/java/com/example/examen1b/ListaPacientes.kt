package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.IntegerRes
import android.support.design.widget.Snackbar
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_lista_pacientes.*

class ListaPacientes : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_pacientes)

        var paciente: Paciente? = this.intent.getParcelableExtra<Paciente>("paciente")
        if (paciente != null) {
            when (paciente.opc) {
                0 -> {
                    paciente.id = Datos.idPaciente()
                    Datos.listaPacientes.add(paciente)

                }
                1 -> {
                    val listaPacientesAux = Datos.listaPacientes.filter { pacienteAux ->
                        pacienteAux.id != paciente.id
                    }
                    Datos.listaPacientes = listaPacientesAux as ArrayList<Paciente>
                }
                2 -> {
                    Datos.listaPacientes.map { pacAux ->
                        if (pacAux.id == paciente.id) {
                            pacAux.nombres = paciente.nombres
                            pacAux.apellidos = paciente.apellidos
                            pacAux.fechaNacimiento = paciente.fechaNacimiento
                            pacAux.hijos = paciente.hijos
                            pacAux.tieneSeguro = paciente.tieneSeguro
                        }
                    }
                }
            }
            Snackbar
                .make(lv_pacientes, Datos.mensaje(paciente.opc), Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, Datos.listaPacientes)
        lv_pacientes.adapter = adapter
        lv_pacientes.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            irDatosPaciente(Datos.listaPacientes[id.toInt()])
        }


    }

    private fun irDatosPaciente(paciente: Paciente) {
        val intent = Intent(
            this,
            DatosPaciente::class.java
        )
        intent.putExtra("paciente", paciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
