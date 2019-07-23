package com.example.examen1b

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class Prueba : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prueba)
        var paciente: Paciente = this.intent.getParcelableExtra<Paciente>("paciente")
        Log.i("crear-med", paciente.nombres)
    }
}
