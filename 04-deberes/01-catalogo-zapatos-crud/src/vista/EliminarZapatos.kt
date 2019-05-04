package vista

import controlador.ListaZapatos
import java.awt.GridLayout
import javax.swing.*

class EliminarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
    val panel: JPanel = JPanel()
    val boton: JButton = JButton("Buscar zapato")
    val txtCodigo: JTextField = JTextField()
    var listaZapatos: ListaZapatos

    init {
        this.listaZapatos = listaZapatos
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        panel.layout = GridLayout()
        txtCodigo.setSize(200, 100)
        boton.setSize(100, 100)
        panel.add(txtCodigo)
        panel.add(boton)
        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 175)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        val botonBuscar = boton.apply {
            addActionListener {
                if (txtCodigo.text != "") {
                    val codigoZapato = txtCodigo.text
                    val existe = listaZapatos.existe(codigoZapato)
                    if (existe) {
                        val mensaje: String = "DESEA ELIMINAR EL SIGUIENTE REGISTRO: \n " +
                                "${listaZapatos.obtenerZapato(codigoZapato)}"
                        if (JOptionPane.showConfirmDialog(null, mensaje) == 0) {
                            listaZapatos.eliminarZapato(codigoZapato)
                            JOptionPane.showMessageDialog(
                                null, "REGISTRO ELIMINADO SATISFACTORIAMENTE"
                            )
                            this.show(false)
                        } else {
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "REGISTRO NO EXISTENTE")
                    }
                }
            }
        }
    }
}
