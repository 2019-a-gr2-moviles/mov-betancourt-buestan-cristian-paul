package vista

import controlador.ListaZapatos
import modelo.Zapato
import java.awt.GridLayout
import javax.swing.*

class ModificarZapatos(title: String, listaZapatos: ListaZapatos) : JFrame() {
    private val panel: JPanel = JPanel()
    private val boton: JButton = JButton("Buscar zapato")
    private val comboCodigos: JComboBox<String> = JComboBox()
    private var listaZapatos: ListaZapatos
    private val listaMarcas = arrayListOf<String>("Adidas", "Puma", "Nike", "Reebook", "Umbro", "Lotto")
    private val listaTipos = arrayListOf<String>("Hombre", "Mujer")
    private val comboMarca: JComboBox<String> = JComboBox()
    private val comboTipo: JComboBox<String> = JComboBox()
    private val comboTalla: JComboBox<String> = JComboBox()


    init {
        listaMarcas.forEach { marca: String ->
            comboMarca.addItem(marca)
        }

        listaTipos.forEach { tipo: String ->
            comboTipo.addItem(tipo)
        }

        this.listaZapatos = listaZapatos

        for (x in 30..42) {
            comboTalla.addItem("$x")
        }

        listaZapatos.obtenerZapatos().forEach { t: Zapato ->
            comboCodigos.addItem(t.getCodigo())
        }
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)

        panel.layout = GridLayout()
        //txtCodigo.setSize(200, 100)
        //boton.setSize(100, 100)
        panel.add(comboCodigos)
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
                if (comboCodigos.selectedIndex > -1) {
                    val codigoZapato = comboCodigos.selectedItem.toString()
                    val existe = listaZapatos.existe(codigoZapato)
                    if (existe) {
                        val color = JOptionPane.showInputDialog("Ingrese el color")
                        val talla = JOptionPane.showInputDialog(
                            "Ingrese la talla: ${comboTalla.getItemAt(0)} - " +
                                    "${comboTalla.getItemAt((comboTalla.itemCount - 1))}"
                        )
                        var mensajeTipo = "Ingrese el tipo: "
                        listaTipos.forEach { s: String ->
                            mensajeTipo += (", $s")
                        }

                        var mensajeMarca = "Ingrese la marca: "
                        listaMarcas.forEach { s: String ->
                            mensajeMarca += (", $s")
                        }

                        val tipo = JOptionPane.showInputDialog(mensajeTipo)
                        val marca = JOptionPane.showInputDialog(mensajeMarca)
                        val cantidad = JOptionPane.showInputDialog("Ingrese la cantidad")
                        val precio = JOptionPane.showInputDialog("Ingrese el precio")

                        if ((listaMarcas.any { s ->
                                String
                                s.equals(marca)
                            }) &&
                            (listaTipos.any { s: String ->
                                s.equals(tipo)
                            }) &&
                                ((talla.toInt() in 30..42))) {
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
                            JOptionPane.showMessageDialog(null, "VALORES DE MARCA, TIPO O TALLA INCORRECTOS")
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "REGISTRO NO EXISTENTE")
                    }

                }
            }
        }
    }

}
