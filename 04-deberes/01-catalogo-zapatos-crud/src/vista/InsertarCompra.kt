package vista

import controlador.ListaCompras
import controlador.ListaZapatos
import java.awt.GridLayout
import java.util.*
import javax.swing.*

class InsertarCompra(title: String, listaCompras: ListaCompras, listaZapatos: ListaZapatos) : JFrame() {
    private val panel: JPanel = JPanel()
    private val panel1: JPanel = JPanel()
    private val panel2: JPanel = JPanel()
    private val panel3: JPanel = JPanel()
    private val panel4: JPanel = JPanel()

    private val labelNombre: JLabel = JLabel("Nombre ")
    private val labelApellido: JLabel = JLabel("Apellido ")
    private val labelCedula: JLabel = JLabel("Cedula ")
    private val txtNombre: JTextField = JTextField()
    private val txtApellido: JTextField = JTextField()
    private val txtCedula: JTextField = JTextField()
    private val botonAgregarZapato: JButton = JButton("Agregar zapato")
    private val botonComprar: JButton = JButton("Confirmar compra")
    private var listaCompras: ListaCompras
    private var listaZapatos: ListaZapatos

    init {
        this.listaZapatos = listaZapatos
        this.listaCompras = listaCompras
        createUI(title)
    }

    private fun createUI(title: String) {
        setTitle(title)
        val layout = GridLayout()
        panel1.layout = layout
        panel2.layout = layout
        panel3.layout = layout
        panel4.layout = layout
        panel1.setSize(600, 95)

        panel1.add(labelNombre)
        panel1.add(txtNombre)

        panel2.add(labelApellido)
        panel2.add(txtApellido)

        panel3.add(labelCedula)
        panel3.add(txtCedula)

        panel4.add(botonAgregarZapato)
        panel4.add(botonComprar)

        panel.layout

        panel.setSize(600, 200)
        panel.add(panel1)
        panel.add(panel2)
        panel.add(panel3)
        panel.add(panel4)

        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(600, 175)
        setLocationRelativeTo(null)
    }

    internal fun showEventDemo() {
        var codigoZapato: String
        var fecha = Date()
        var listaCodigoZapatos: HashMap<String, Int> = HashMap()
        var cantidad: Int
        botonAgregarZapato.apply {
            addActionListener {
                val tabla = BuscarZapatos("Lista de zapatos", listaZapatos)
                tabla.show()
                while (true) {
                    codigoZapato = ""
                    cantidad = 0
                    if (JOptionPane.showConfirmDialog(null, "DESEA AGREGAR UN ZAPATO") == 0) {
                        codigoZapato = JOptionPane.showInputDialog("INGRESE EL CODIGO DEL ZAPATO DESEADO")
                        if (listaCompras.existeZapato(codigoZapato)) {
                            cantidad = JOptionPane.showInputDialog("INGRESE LA CANTIDAD DESEADA").toInt()
                            if (listaCompras.existeZapatos(codigoZapato, cantidad)) {
                                JOptionPane.showMessageDialog(null, "ZAPATO AGREGADO CORRECTAMENTE")
                                listaCodigoZapatos.put(codigoZapato, cantidad)
                            } else {
                                JOptionPane.showMessageDialog(null, "CANTIDAD DE ZAPATOS INSUFICIENTE")
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "CODIGO INCORRECTO")
                        }
                    } else {
                        tabla.show(false)
                        break
                    }

                }
            }

            botonComprar.apply {
                addActionListener {
                    if (listaCodigoZapatos.size > 0) {
                        if (!txtNombre.equals("") && !txtApellido.equals("") && !txtCedula.equals("")) {
                            if ((JOptionPane.showConfirmDialog(
                                    null,
                                    "ACEPTA LA COMPRA DE $${listaCompras.obtenerValorTotal(listaCodigoZapatos)}"
                                )) == 0
                            ) {
                                JOptionPane.showMessageDialog(null, "COMPRA REALIZADA SATISFACTORIAMENTE")
                                botonComprar.show(false)
                                botonAgregarZapato.show(false)
                                listaCompras.ingresarCompra(
                                    fecha,
                                    txtNombre.text,
                                    txtApellido.text,
                                    txtCedula.text,
                                    listaCodigoZapatos
                                )

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "INGRESE LOS CAMPOS CORRECTAMENTE")
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "NO TIENE ZAPATOS AGREGADOS")
                    }
                }
            }
        }

    }
}
