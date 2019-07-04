package com.example.aplicacion2

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btn_parcelable.setOnClickListener {
            irParcelable()
        }

        btn_adapter.setOnClickListener {
            irListView()
        }

        btn_rv.setOnClickListener {
            irRecyclerView()
        }

        btn_intent_respuesta.setOnClickListener {
            irIntentRespuesta()
        }

        btn_http.setOnClickListener {
            irIntentHTTP()
        }
        btn_mapa.setOnClickListener {
            irMapa()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun irParcelable() {
        //intent explícito
        val intentExplicito = Intent(
            this,
            Parcelable::class.java
        )
        val cristian = Usuario("Cristian", 21, Date(), 0.0)
        val firulais = Mascota("Firulais", cristian)

        intentExplicito.putExtra("usuario", cristian)
        intentExplicito.putExtra("mascota", firulais)
        startActivity(intentExplicito)
    }

    fun irListView() {
        //intent explícito
        val intentExplicito = Intent(
            this,
            ListViewActivity::class.java
        )

        startActivity(intentExplicito)
    }

    fun irRecyclerView() {
        val intent = Intent(
            this,
            ReciclerViewActivity::class.java
        )

        startActivity(intent)
    }

    fun irIntentRespuesta() {
        val intent = Intent(
            this,
            IntentRespuestaActivity::class.java
        )

        startActivity(intent)
    }

    fun irIntentHTTP() {
        val intent = Intent(
            this,
            ConexionHttpActivity::class.java
        )
        startActivity(intent)
    }

    fun irMapa() {
        val intent = Intent(
            this,
            MapsActivity::class.java
        )
        startActivity(intent)
    }

}

