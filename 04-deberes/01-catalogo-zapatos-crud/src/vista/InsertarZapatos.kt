package vista

import controlador.ListaZapatos
import java.awt.GridLayout
import javax.swing.*

class InsertarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
    private val panel: JPanel = JPanel()
    private val labelCodigo: JLabel = JLabel("Código")
    private val labelColor: JLabel = JLabel("Color")
    private val labelTalla: JLabel = JLabel("Talla")
    private val labelTipo: JLabel = JLabel("Tipo")
    private val labelMarca: JLabel = JLabel("Marca")
    private val labelCantidad: JLabel = JLabel("Cantidad")
    private val labelPrecio: JLabel = JLabel("Precio")
    private val txtCodigo: JTextField = JTextField()
    private val txtColor: JTextField = JTextField()
    private val comboMarca: JComboBox<String> = JComboBox()
    private val txtCantidad: JTextField = JTextField()
    private val txtPrecio: JTextField = JTextField()
    private val boton: JButton = JButton("Ingresar Datos")
    private val comboTipo = JComboBox<String>()
    private val comboTalla = JComboBox<String>()
    private var listaZapatos: ListaZapatos
    private val listaMarcas = arrayListOf("Adidas", "Puma", "Nike", "Reebook", "Umbro", "Lotto")
    private val listaTipos = arrayListOf("Hombre", "Mujer")


    init {
        this.listaZapatos = listaZapatos

        for (x in 30..42) {
            comboTalla.addItem("$x")
        }
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        panel.layout = null

        labelCodigo.setBounds(5, 5, 150, 25)
        txtCodigo.setBounds(160, 5, 150, 25)

        labelColor.setBounds(5, 35, 150, 25)
        txtColor.setBounds(160, 35, 150, 25)

        labelMarca.setBounds(5, 65, 150, 25)
        listaMarcas.forEach { marca ->
            String
            comboMarca.addItem(marca)
        }

        comboMarca.setBounds(160, 65, 150, 25)

        labelTalla.setBounds(5, 95, 150, 25)
        comboTalla.setBounds(160, 95, 150, 25)

        labelTipo.setBounds(5, 125, 150, 25)

        listaTipos.forEach { tipo: String ->
            comboTipo.addItem(tipo)
        }

        comboTipo.setBounds(160, 125, 150, 25)

        labelCantidad.setBounds(5, 155, 150, 25)
        txtCantidad.setBounds(160, 155, 150, 25)

        labelPrecio.setBounds(5, 185, 150, 25)
        txtPrecio.setBounds(160, 185, 150, 25)

        boton.setBounds(90, 240, 130, 30)


        panel.layout = null
        panel.add(labelCodigo)
        panel.add(txtCodigo)

        panel.add(txtColor)
        panel.add(labelColor)

        panel.add(labelMarca)
        panel.add(comboMarca)

        panel.add(labelCantidad)
        panel.add(txtCantidad)

        panel.add(labelPrecio)
        panel.add(txtPrecio)

        panel.add(labelTipo)
        panel.add(comboTipo)

        panel.add(labelTalla)
        panel.add(comboTalla)

        panel.add(boton)

        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(340, 325)
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
                        val talla = comboTalla.selectedItem.toString()
                        val tipo = comboTipo.selectedItem.toString()
                        val marca = comboMarca.selectedItem.toString()
                        val cantidad = txtCantidad.text
                        val precio = txtPrecio.text

                        listaZapatos.insertarZapato(
                            color, tipo, talla.toInt(), codigoZapato, marca, cantidad.toInt(), precio.toDouble()
                        )

                        JOptionPane.showMessageDialog(null, "REGISTRO INGRESADO SATISFACTORIAMENTE")
                        this.show(false)
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
