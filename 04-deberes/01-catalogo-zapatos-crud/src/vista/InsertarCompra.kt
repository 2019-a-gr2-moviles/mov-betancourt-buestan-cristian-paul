package vista

import controlador.ListaCompras
import controlador.ListaZapatos
import java.util.*
import javax.swing.*

class InsertarCompra(title: String, listaCompras: ListaCompras, listaZapatos: ListaZapatos) : JFrame() {
    private val panel: JPanel = JPanel()


    private val labelNombre: JLabel = JLabel("Nombre ")
    private val labelApellido: JLabel = JLabel("Apellido ")
    private val labelCedula: JLabel = JLabel("Cédula ")
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

        labelNombre.setBounds(5, 5, 150, 25)
        txtNombre.setBounds(160, 5, 150, 25)

        labelApellido.setBounds(5, 35, 150, 25)
        txtApellido.setBounds(160, 35, 150, 25)

        labelCedula.setBounds(5, 65, 150, 25)
        txtCedula.setBounds(160, 65, 150, 25)

        botonAgregarZapato.setBounds(5, 105, 150, 25)
        botonComprar.setBounds(160, 105, 150, 25)

        panel.layout = null

        panel.add(labelNombre)
        panel.add(txtNombre)

        panel.add(labelApellido)
        panel.add(txtApellido)

        panel.add(labelCedula)
        panel.add(txtCedula)

        panel.add(botonComprar)
        panel.add(botonAgregarZapato)

        this.add(panel)
        //defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(340, 175)
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
