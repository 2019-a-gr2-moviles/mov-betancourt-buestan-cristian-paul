package vista

import controlador.ListaZapatos
import java.awt.GridLayout
import javax.swing.*

class ModificarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
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
        setSize(600, 100)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        val botonBuscar = boton.apply {
            //ctionCommand = "Buscar"
            addActionListener {
                if (txtCodigo.text != "") {
                    val codigoZapato = txtCodigo.text
                    val existe = listaZapatos.existe(codigoZapato)
                    if (existe) {
                        val color = JOptionPane.showInputDialog("Ingrese el color")
                        val talla = JOptionPane.showInputDialog("Ingrese la talla")
                        val tipo = JOptionPane.showInputDialog("Ingrese el tipo")
                        val marca = JOptionPane.showInputDialog("Ingrese la marca")
                        val cantidad = JOptionPane.showInputDialog("Ingrese la cantidad")
                        val precio = JOptionPane.showInputDialog("Ingrese el precio")

                        listaZapatos.actualizarZapato(
                            color,
                            tipo,
                            talla.toInt(),
                            codigoZapato,
                            marca,
                            cantidad.toInt(),
                            precio.toDouble()
                        )

                        JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO SATISFACTORIAMENTE")
                        this.show(false)
                    } else {
                        JOptionPane.showMessageDialog(null, "REGISTRO NO EXISTENTE")
                    }

                }
            }
        }
    }

}
