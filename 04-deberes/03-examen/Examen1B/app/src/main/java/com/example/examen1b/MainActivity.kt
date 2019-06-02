package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_entrar.setOnClickListener {
            Datos.usuario= txt_usuario.text.toString()
            irGestionPacientes()
        }
    }

    private fun irGestionPacientes() {
        val intent = Intent(
            this,
            GestionPacientes::class.java
        )
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }

}
