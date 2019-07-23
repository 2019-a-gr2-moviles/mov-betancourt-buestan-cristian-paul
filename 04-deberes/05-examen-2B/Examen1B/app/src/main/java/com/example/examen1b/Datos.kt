package com.example.examen1b

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

class Datos {
    companion object {
        var listaPacientes: ArrayList<Paciente> = listaPacientesInicial()
        var listaMedicamentos: ArrayList<Medicamento> = listaMedicamentoInicial()
        private var idPaciente: Int = 0
        private var idMedicamento: Int = 0
        var usuario = ""

        fun mensaje(opc: Int): String {
            return when (opc) {
                0 -> {
                    return StringBuilder().append(usuario).append(" ha insertado.").toString()
                }
                1 -> {
                    return StringBuilder().append(usuario).append(" ha eliminado.").toString()
                }
                2 -> {
                    return StringBuilder().append(usuario).append(" ha actualizado.").toString()
                }

                else -> {
                    return "nada"
                }
            }
        }

        private fun listaPacientesInicial(): ArrayList<Paciente> {
            val lista = arrayListOf<Paciente>()
            lista.add(Paciente(idPaciente(), "Cristian", "Betancourt", "01/03/1998", 0, false, -1))
            return lista
        }

        private fun listaMedicamentoInicial(): ArrayList<Medicamento> {
            val lista = arrayListOf<Medicamento>()
            lista.add(Medicamento(idMedicamento(), 1.0, "Buprex", "AAA", "Gripe", "01/01/2020", 2, 0, -1))
            return lista
        }

        fun idPaciente(): Int {
            idPaciente++
            return (idPaciente - 1)
        }

        fun idMedicamento(): Int {
            idMedicamento++
            return (idMedicamento - 1)
        }
    }
}