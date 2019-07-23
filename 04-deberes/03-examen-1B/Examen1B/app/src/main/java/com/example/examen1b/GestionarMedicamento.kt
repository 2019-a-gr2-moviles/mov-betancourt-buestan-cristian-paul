package com.example.examen1b

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.text.Editable
import android.util.Log
import kotlinx.android.synthetic.main.activity_gestionar_medicamento.*
import kotlinx.android.synthetic.main.activity_lista_medicamentos.*

class GestionarMedicamento : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gestionar_medicamento)
        var medicamento: Medicamento = this.intent.getParcelableExtra<Medicamento>("medicamento")
        colocarDatosMed(medicamento)

        Log.i(
            "ACTUALIZAR-MEDICAMENTO", "${medicamento.nombre} ${medicamento.composicion} " +
                    "${medicamento.usadoPara} ${medicamento.fechaCaducidad} " +
                    "${medicamento.numeroPastillas} ${medicamento.gramosAIngerir} " +
                    "${medicamento.pacienteId}"
            )
        //        txt_gra_med_act.text=medicamento.gramosAIngerir.toString() as Editable
//        txt_num_pas_med_act.setText (medicamento.gramosAIngerir.toInt())

        btn_eli_med.setOnClickListener {
            medicamento.opc = 1
            irListaMedicamentos(medicamento)
        }

        btn_act_med.setOnClickListener {
            val medicamentoAux = Medicamento(
                medicamento.id,
                txt_gra_med_act.text.toString().toDouble(),
                txt_nom_med_act.text.toString(),
                txt_comp_med_act.text.toString(),
                txt_uso_med_act.text.toString(),
                fec_cad_med_act.text.toString(),
                txt_num_pas_med_act.text.toString().toInt(),
                medicamento.pacienteId, 2
            )
            irListaMedicamentos(medicamentoAux)
        }
    }

    fun colocarDatosMed(medicamento: Medicamento) {
        txt_nom_med_act.setText(medicamento.nombre)
        txt_comp_med_act.setText(medicamento.composicion)
//        txt_gra_med_act.text=medicamento.gramosAIngerir.toString() as Editable
//        txt_num_pas_med_act.setText (medicamento.gramosAIngerir.toInt())
        txt_uso_med_act.setText(medicamento.usadoPara)
         fec_cad_med_act.setText(medicamento.fechaCaducidad)
    }

    fun irListaMedicamentos(medicamento: Medicamento) {
        val intent = Intent(
            this,
            ListaMedicamentos::class.java
        )
        intent.putExtra("medicamento", medicamento)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}
