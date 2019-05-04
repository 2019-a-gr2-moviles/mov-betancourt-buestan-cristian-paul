package vista

import controlador.ListaCompras
import controlador.ListaZapatos
import java.awt.GridLayout
import javax.swing.*

class EliminarCompra(title: String, listaCompras: ListaCompras, listaZapatos: ListaZapatos) : JFrame() {
    val panel: JPanel = JPanel()
    val boton: JButton = JButton("Buscar compra")
    val txtNumeroCompra: JTextField = JTextField()
    val listaZapatos: ListaZapatos
    val listaCompras: ListaCompras

    init {
        this.listaCompras = listaCompras
        this.listaZapatos = listaZapatos
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        panel.layout = GridLayout()
        txtNumeroCompra.setSize(200, 100)
        boton.setSize(100, 100)
        panel.add(txtNumeroCompra)
        panel.add(boton)
        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 175)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {

        val botonBuscar = boton.apply {
            addActionListener {
                if (txtNumeroCompra.text != "") {
                    val numeroCompra = txtNumeroCompra.text.toInt()
                    val existe = listaCompras.existe(numeroCompra)
                    if (existe) {
                        val mensaje: String =
                            "¿DESEA ELIMINAR LA SIGUIENTE COMPRA? \n" +
                                    "${listaCompras.obtenerCompra(numeroCompra)}"
                        if (JOptionPane.showConfirmDialog(null, mensaje) == 0) {
                            listaCompras.eliminarCompra(numeroCompra)
                            JOptionPane.showMessageDialog(
                                null, "COMPRA ELIMINADA SATISFACTORIAMENTE"
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
