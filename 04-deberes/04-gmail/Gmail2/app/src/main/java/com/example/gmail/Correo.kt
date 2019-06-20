package com.example.gmail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_correo.*

class Correo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_correo)

        val mensaje: Mensaje = this.intent.getParcelableExtra<Mensaje>("mensaje")
        lbl_remitente.text = " DE: " + mensaje.remitente
        lbl_destinatario.text = " PARA: cristianbb98@gmail.com "
        lbl_asunto.text = " ASUNTO: " + mensaje.asunto
        lbl_contenido.text = " " + mensaje.contenido
    }
}
