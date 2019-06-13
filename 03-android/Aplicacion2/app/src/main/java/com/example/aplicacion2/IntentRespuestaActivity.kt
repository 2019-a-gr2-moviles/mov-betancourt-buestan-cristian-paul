package com.example.aplicacion2

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import kotlinx.android.synthetic.main.activity_intent_respuesta.*
import kotlinx.android.synthetic.main.content_main.*

class IntentRespuestaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_respuesta)

        btn_enviar_intent_respuesta.setOnClickListener {
            enviarIntentConRespuesta()
        }
        btn_enviar_respuesta_propia.setOnClickListener {
            enviarIntentConRespuestaPropia()
        }
    }

    fun enviarIntentConRespuesta() {
        val intentConRespuesta = Intent(
            Intent.ACTION_PICK,
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI
        )
        this.startActivityForResult(intentConRespuesta, 304)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (resultCode) {
            Activity.RESULT_OK -> {
                Log.i("intent-respuesta", "Lo logramos!!!! ${Activity.RESULT_OK}")
                when (requestCode) {
                    304 -> {
                        Log.i("intent-respuesta", "Contacto llego!!!!")
                        val uri = data?.data
                        var cursor = contentResolver.query(uri, null, null, null, null)
                        cursor.moveToFirst()
                        val indiceTelefono = cursor.getColumnIndex(
                            ContactsContract.CommonDataKinds.Phone.NUMBER
                        )

                        val telefono = cursor.getString(indiceTelefono)
                        Log.i("intent-respuesta", "Telefono ${telefono}")

                    }
                    305 -> {
                        val nombre = data?.getStringExtra("nombreUsuario")
                        val edad = data?.getIntExtra("edadUsuario",0)
                        Log.i("intent-respuesta", "Nombre: $nombre //////////   Edad: $edad")
                    }
                }
            }
            Activity.RESULT_CANCELED -> {
                Log.i("intent-respuesta", "No escogiooo!!! ${Activity.RESULT_CANCELED}")
            }
        }
    }

    fun enviarIntentConRespuestaPropia() {
        val intentPropio = Intent(this, ResultadoPropioActivity::class.java)
        this.startActivityForResult(intentPropio, 305)

    }
}
