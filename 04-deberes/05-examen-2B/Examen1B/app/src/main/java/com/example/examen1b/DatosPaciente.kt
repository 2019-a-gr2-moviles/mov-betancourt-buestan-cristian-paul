package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_datos_paciente.*

class DatosPaciente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_datos_paciente)
        var paciente: Paciente = this.intent.getParcelableExtra<Paciente>("paciente")
        colocarDatos(paciente)
        btn_eli_pac.setOnClickListener {
            paciente.opc = 1
            irListaPacientes(paciente)
        }
        btn_ges_med.setOnClickListener {
            irListaMedicamentos(paciente)
        }

        btn_crear_med.setOnClickListener {
            irCrearMedicamento(paciente)
        }

        btn_act_pac.setOnClickListener {
            val pacAct = Paciente(
                paciente.id,
                txt_nom_pac_act.text.toString(),
                txt_ape_pac_act.text.toString(),
                fec_nac_pac_act.text.toString(),
                txt_hij_pac_act.text.toString().toInt(),
                sw_seg_pac_act.isChecked,
                2
            )
            irListaPacientes(pacAct)
        }
    }

    private fun irListaPacientes(paciente: Paciente) {
        val intent = Intent(
            this,
            ListaPacientes::class.java
        )
        intent.putExtra("paciente", paciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun colocarDatos(paciente: Paciente) {
        txt_nom_pac_act.setText(paciente.nombres)
        txt_ape_pac_act.setText(paciente.apellidos)
        fec_nac_pac_act.setText(paciente.fechaNacimiento)
        // txt_hij_pac_act.setRawInputType(paciente.hijos)
        sw_seg_pac_act.isChecked = paciente.tieneSeguro
    }

    private fun irListaMedicamentos(paciente: Paciente) {
        val intent = Intent(
            this,
            ListaMedicamentos::class.java
        )
        intent.putExtra("paciente", paciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

    private fun irCrearMedicamento(paciente: Paciente) {
        val intent = Intent(
            this,
            CrearMedicamento::class.java
        )
        intent.putExtra("paciente", paciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
