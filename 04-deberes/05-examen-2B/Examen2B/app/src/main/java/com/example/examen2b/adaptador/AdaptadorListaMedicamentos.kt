package com.example.examen2b.adaptador

import com.example.examen2b.R
import com.example.examen2b.modelo.Paciente
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.examen2b.actividades.ListaMedicamentos
import com.example.examen2b.modelo.Medicamento


class AdaptadorListaMedicamentos(
    private val listaMedicamentos: ArrayList<Medicamento>,
    private val contexto: ListaMedicamentos,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorListaMedicamentos.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var idPacienteTextView: TextView
        var idTextView: TextView
        var nombreTextView: TextView
        var composicionTextView: TextView
        var gramosTextView: TextView
        var pastillasTextView: TextView
        var usoTextView: TextView
        var fechaCaducidadTextView: TextView
        var eliminarBoton: Button
        var actualizarBoton: Button

        init {

            idPacienteTextView = view.findViewById(R.id.txv_id_pac_med) as TextView
            idTextView = view.findViewById(R.id.txv_id_med) as TextView
            nombreTextView = view.findViewById(R.id.txv_nombre_med) as TextView
            composicionTextView = view.findViewById(R.id.txv_composicion_med) as TextView
            gramosTextView = view.findViewById(R.id.txv_gramos_med) as TextView
            pastillasTextView = view.findViewById(R.id.txv_numero_pastillas_med) as TextView
            usoTextView = view.findViewById(R.id.txv_uso_med) as TextView
            fechaCaducidadTextView = view.findViewById(R.id.txv_fecha_caducidad_med) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eliminar_med) as Button
            actualizarBoton = view.findViewById(R.id.btn_actualizar_med) as Button

            actualizarBoton.setOnClickListener {
                val medicamento = Medicamento(
                    idTextView.text.toString().toInt(),
                    gramosTextView.text.toString().toDouble(),
                    nombreTextView.text.toString(),
                    composicionTextView.text.toString(),
                    usoTextView.text.toString(),
                    fechaCaducidadTextView.text.toString(),
                    pastillasTextView.text.toString().toInt(),
                    idPacienteTextView.text.toString().toInt(),
                    "0", "0"
                )
                contexto.irActualizarMedicamento(medicamento)

            }

            eliminarBoton.setOnClickListener {
                contexto.eliminarMedicamento(idTextView.text.toString().toInt())

            }
        }

    }

    //Esta función define el template que vamos a utilizar.
    // El template esta en la carpeta de recursos res/layout -> layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaMedicamentos.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_medicamento,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    //Devuelve el número de items de la lista
    override fun getItemCount(): Int {
        return listaMedicamentos.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaMedicamentos.MyViewHolder, position: Int) {
        val medicamento: Medicamento = listaMedicamentos[position]
        myViewHolder.idTextView.text = medicamento.id.toString()
        myViewHolder.idPacienteTextView.text = medicamento.idPaciente.toString()
        myViewHolder.nombreTextView.text = medicamento.nombre
        myViewHolder.composicionTextView.text = medicamento.composicion
        myViewHolder.gramosTextView.text = medicamento.gramosAIngerir.toString()
        myViewHolder.fechaCaducidadTextView.text = medicamento.fechaCaducidad
        myViewHolder.pastillasTextView.text = medicamento.numeroPastillas.toString()
        myViewHolder.usoTextView.text = medicamento.usadoPara
    }

//    fun crearCliente(id: Int, nombre: String, apellido: String, cedula: String): Cliente {
//        val cliente = Cliente(
//            null,
//            null,
//            null,
//            id,
//            nombre,
//            apellido,
//            cedula
//        )
//        return cliente
//    }
}