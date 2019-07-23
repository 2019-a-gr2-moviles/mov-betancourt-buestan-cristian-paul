package com.example.examen1b

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_crear_medicamento.*

class CrearMedicamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_medicamento)

        var paciente: Paciente = this.intent.getParcelableExtra<Paciente>("paciente")
        Log.i("crear-med", paciente.nombres)


        btn_ins_med.setOnClickListener {
            val medicamento: Medicamento = Medicamento(
                0,
                txt_gra_med.text.toString().toDouble(),
                txt_nom_med.text.toString(),
                txt_comp_med.text.toString(),
                txt_uso_med.text.toString(),
                fec_cad_med.text.toString(),
                txt_num_pas_med.text.toString().toInt(),
                paciente.id,
                0
            )
            irListaMedicamento(medicamento)
        }
    }

    private fun irListaMedicamento(medicamento: Medicamento) {
        val intent = Intent(
            this,
            ListaMedicamentos::class.java
        )
        intent.putExtra("medicamento", medicamento)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

    }
}
