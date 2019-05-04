package vista

import controlador.ListaZapatos
import java.awt.GridLayout
import javax.swing.*

class InsertarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
    private val panel: JPanel = JPanel()
    private val panel1: JPanel = JPanel()
    private val panel2: JPanel = JPanel()
    private val panel3: JPanel = JPanel()
    private val panel4: JPanel = JPanel()
    private val panel5: JPanel = JPanel()
    private val panel6: JPanel = JPanel()
    private val panel7: JPanel = JPanel()
    private val labelCodigo: JLabel = JLabel("Código")
    private val labelColor: JLabel = JLabel("Color")
    private val labelTalla: JLabel = JLabel("Talla")
    private val labelTipo: JLabel = JLabel("Tipo")
    private val labelMarca: JLabel = JLabel("Marca")
    private val labelCantidad: JLabel = JLabel("Cantidad")
    private val labelPrecio: JLabel = JLabel("Precio")
    private val txtCodigo: JTextField = JTextField()
    private val txtColor: JTextField = JTextField()
    private val txtMarca: JTextField = JTextField()
    private val txtTipo: JTextField = JTextField()
    private val txtTalla: JTextField = JTextField()
    private val txtCantidad: JTextField = JTextField()
    private val txtPrecio: JTextField = JTextField()
    private val boton: JButton = JButton("Ingresar Datos")
    private var listaZapatos: ListaZapatos

    init {
        this.listaZapatos = listaZapatos
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        val layout = GridLayout()
        panel1.layout = layout
        panel2.layout = layout
        panel3.layout = layout
        panel4.layout = layout
        panel5.layout = layout
        panel6.layout = layout

        panel1.setSize(600, 95)
        txtCodigo.setSize(400, 75)

        panel1.add(labelCodigo)
        panel1.add(txtCodigo)

        panel2.add(labelColor)
        panel2.add(txtColor)

        panel3.add(labelMarca)
        panel3.add(txtMarca)

        panel4.add(labelTalla)
        panel4.add(txtTalla)

        panel5.add(labelTipo)
        panel5.add(txtTipo)

        panel6.add(labelCantidad)
        panel6.add(txtCantidad)

        panel7.add(labelPrecio)
        panel7.add(txtPrecio)

        panel.layout
        boton.setSize(100, 100)

        panel.setSize(600, 200)
        panel.add(panel1)
        panel.add(panel2)
        panel.add(panel3)
        panel.add(panel4)
        panel.add(panel5)
        panel.add(panel6)
        panel.add(panel7)
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
                    if (!existe) {

                        val color = txtColor.text
                        val talla = txtTalla.text
                        val tipo = txtTipo.text
                        val marca = txtMarca.text
                        val cantidad = txtCantidad.text
                        val precio = txtPrecio.text

                        listaZapatos.insertarZapato(
                            color, tipo, talla.toInt(), codigoZapato, marca, cantidad.toInt(), precio.toDouble()
                        )

                        JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO SATISFACTORIAMENTE")
                        show(false)
                    } else {
                        JOptionPane.showMessageDialog(null, "CÓDIGO YA EXISTENTE")
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "COMPLETE TODOS LOS CAMPOS")
                }
            }
        }
    }

}
