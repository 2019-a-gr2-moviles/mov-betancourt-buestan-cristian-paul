package com.example.examen2b.adaptador

import com.example.examen2b.R
import com.example.examen2b.actividades.ListaPacientes
import com.example.examen2b.modelo.Paciente
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView


class AdaptadorListaPacientes(
    private val listaPacientes: ArrayList<Paciente>,
    private val contexto: ListaPacientes,
    private val recyclerView: androidx.recyclerview.widget.RecyclerView
) :
    androidx.recyclerview.widget.RecyclerView.Adapter<AdaptadorListaPacientes.MyViewHolder>() {

    inner class MyViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view) {
        var infoTextView: TextView
        var idTextView: TextView
        var nombresTextView: TextView
        var apellidosTextView: TextView
        var fechaNacimientoTextView: TextView
        var hijosTextView: TextView
        var seguroTextView: TextView
        var eliminarBoton: Button
        var actualizarBoton: Button

        init {

            infoTextView = view.findViewById(R.id.txv_info_pac) as TextView
            idTextView = view.findViewById(R.id.txv_id_pac) as TextView
            nombresTextView = view.findViewById(R.id.txv_nombres_pac) as TextView
            apellidosTextView = view.findViewById(R.id.txv_apellidos_pac) as TextView
            fechaNacimientoTextView = view.findViewById(R.id.txv_fecha_nacimiento_pac) as TextView
            hijosTextView = view.findViewById(R.id.txv_numero_hijos_pac) as TextView
            seguroTextView = view.findViewById(R.id.txv_seguro_pac) as TextView
            eliminarBoton = view.findViewById(R.id.btn_eliminar_pac) as Button
            actualizarBoton = view.findViewById(R.id.btn_actualizar_pac) as Button

            val layout = view.findViewById(R.id.lay_paciente) as LinearLayout

            layout.setOnClickListener {
                val paciente: Paciente? = listaPacientes.find { paciente ->
                    idTextView.text.toString().toInt() == paciente.id
                }
                contexto.irGestionarMedicamentos(idTextView.text.toString().toInt(), paciente!!.medicamentoDePaciente)
            }

            actualizarBoton.setOnClickListener {
                var seguro: Boolean = false
                if (seguroTextView.text.toString() == "SI") {
                    seguro = true
                }
                val paciente = Paciente(
                    null,
                    idTextView.text.toString().toInt(),
                    nombresTextView.text.toString(),
                    apellidosTextView.text.toString(),
                    fechaNacimientoTextView.text.toString(),
                    hijosTextView.text.toString().toInt(),
                    seguro
                )
                contexto.irActualizarPaciente(paciente)
            }

            eliminarBoton.setOnClickListener {
                // crear paciente
                contexto.eliminarPaciente(idTextView.text.toString().toInt())

            }
        }

    }

    //Esta función define el template que vamos a utilizar.
    // El template esta en la carpeta de recursos res/layout -> layout
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): AdaptadorListaPacientes.MyViewHolder {
        val itemView = LayoutInflater
            .from(p0.context)
            .inflate(
                R.layout.layout_paciente,
                p0,
                false
            )
        return MyViewHolder(itemView)
    }

    //Devuelve el número de items de la lista
    override fun getItemCount(): Int {
        return listaPacientes.size
    }

    override fun onBindViewHolder(myViewHolder: AdaptadorListaPacientes.MyViewHolder, position: Int) {
        val paciente: Paciente = listaPacientes[position]
        myViewHolder.idTextView.text = paciente.id.toString()
        myViewHolder.infoTextView.text = "Paciente #${paciente.id}"
        myViewHolder.nombresTextView.text = paciente.nombres
        myViewHolder.apellidosTextView.text = paciente.apellidos
        myViewHolder.fechaNacimientoTextView.text = paciente.fechaNacimiento
        myViewHolder.hijosTextView.text = paciente.hijos.toString()
        if (paciente.tieneSeguro) {
            myViewHolder.seguroTextView.text = "SI"
        } else {
            myViewHolder.seguroTextView.text = "NO"
        }


    }

}