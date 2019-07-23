package com.example.examen1b

import android.content.ComponentName
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_paciente.*
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat

class CrearPaciente : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_paciente)
        btn_ins_pac.setOnClickListener {

            irListaPacientes(
                txt_nom_pac.text,
                txt_ape_pac.text,
                dp_fec_nac_pac.text,
                txt_hij_pac.text,
                sw_seg_pac.isChecked
            )

        }
    }

    public fun irListaPacientes(
        nombre: Editable,
        apellido: Editable,
        fechaNacimiento: Editable,
        hijos: Editable,
        seguro: Boolean
    ) {

//        Log.i("crear-usr", "$nombre $apellido $fechaNacimiento $hijos $seguro")
//        Log.i("fecha", "fecha: ${SimpleDateFormat("dd/mm/yyyy").parse(fechaNacimiento.toString())}")

        val intent = Intent(
            this,
            ListaPacientes::class.java
        )

        val paciente = Paciente(
            0,
            nombre.toString(),
            apellido.toString(),
           fechaNacimiento.toString(),
            hijos.toString().toInt(),
            seguro, 0
        )

        intent.putExtra("paciente", paciente)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
