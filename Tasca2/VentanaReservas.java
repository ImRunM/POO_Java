import javax.swing.*;

import java.awt.*;

public class VentanaReservas extends JFrame{
    private JTextField nombre, telefono, email, numPersonas, entrada, salida;
    private JTextArea direccion;
    private JRadioButton masculino, femenino, otro;
    private JComboBox<String> categoriaHabitacion = new JComboBox<String>();
    private JCheckBox desayuno, almuerzo, cena;
    private JButton reiniciar, enviar, cancelar;
    
    public VentanaReservas(){
        super();
        this.init();
    }

    public VentanaReservas(String title){
        super(title);
        this.init();
    }

    private void init(){
        this.setSize(400, 535);
        this.setLocation(100, 80);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panelPrincipal = new JPanel(new BorderLayout(0, 20));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(20, 20, 20,20));
        panelPrincipal.add(crearPanelDatosPersonales(), BorderLayout.NORTH);
        panelPrincipal.add(crearPanelDetallesReserva(), BorderLayout.CENTER);
        panelPrincipal.add(CrearPanelBotones(), BorderLayout.SOUTH);
        this.setContentPane(new JScrollPane(panelPrincipal));
    }

    // Panel para los datos personales
    private JPanel crearPanelDatosPersonales(){
        JPanel panelDatosPersonales = new JPanel();
        panelDatosPersonales.setLayout(new BoxLayout(panelDatosPersonales, BoxLayout.Y_AXIS));
        panelDatosPersonales.setBorder(
            BorderFactory.createTitledBorder("Datos personales")
        );

        panelDatosPersonales.add(crearPanelNombre());
        panelDatosPersonales.add(Box.createVerticalStrut(20));
        panelDatosPersonales.add(crearPanelGenero());
        panelDatosPersonales.add(Box.createVerticalStrut(20));
        panelDatosPersonales.add(crearPanelDireccion());
        panelDatosPersonales.add(Box.createVerticalStrut(20));
        panelDatosPersonales.add(crearPanelTelefono());
        panelDatosPersonales.add(Box.createVerticalStrut(20));
        panelDatosPersonales.add(crearPanelEmail());

        return panelDatosPersonales;
    }

    // Panel para el nombre
    private JPanel crearPanelNombre(){
        JPanel panelNombre = new JPanel();
        panelNombre.setLayout(new BoxLayout(panelNombre, BoxLayout.X_AXIS));

        JLabel eNombre = new JLabel("Nombre");
        nombre = new JTextField();

        panelNombre.add(eNombre);
        panelNombre.add(Box.createHorizontalStrut(10));
        panelNombre.add(nombre);
        
        return panelNombre; 
    }

    // Panel para el genero
    private JPanel crearPanelGenero(){
    JPanel panelGenero = new JPanel();
    panelGenero.setLayout(new BoxLayout(panelGenero, BoxLayout.X_AXIS));

    JLabel eGenero = new JLabel("Género");
    masculino = new JRadioButton("Masculino");
    femenino = new JRadioButton("Femenino");
    otro = new JRadioButton("Otro");

    ButtonGroup grupoGenero = new ButtonGroup();
    grupoGenero.add(masculino);
    grupoGenero.add(femenino);
    grupoGenero.add(otro);


    panelGenero.add(eGenero);
    panelGenero.add(Box.createHorizontalStrut(20));
    panelGenero.add(masculino);
    panelGenero.add(Box.createHorizontalStrut(20));
    panelGenero.add(femenino);
    panelGenero.add(Box.createHorizontalStrut(20));
    panelGenero.add(otro);
    
    return panelGenero; 
}    
    // Panel para la descipcion
    private JPanel crearPanelDireccion(){
        JPanel panelDireccion = new JPanel();
        panelDireccion.setLayout(new BoxLayout(panelDireccion, BoxLayout.X_AXIS));

        JLabel eDireccion = new JLabel("Dirección");
        direccion = new JTextArea();

        panelDireccion.add(eDireccion);
        panelDireccion.add(Box.createHorizontalStrut(10));
        panelDireccion.add(direccion);
        
        return panelDireccion; 
    }
    
    // Panel para el teléfono
    private JPanel crearPanelTelefono(){
        JPanel panelTelefono = new JPanel();
        panelTelefono.setLayout(new BoxLayout(panelTelefono, BoxLayout.X_AXIS));

        JLabel eTelef = new JLabel("Teléfono");
        telefono = new JTextField();

        panelTelefono.add(eTelef);
        panelTelefono.add(Box.createHorizontalStrut(10));
        panelTelefono.add(telefono);
        
        return panelTelefono; 
    }

    // Panel para el email
    private JPanel crearPanelEmail(){
        JPanel panelEmail = new JPanel();
        panelEmail.setLayout(new BoxLayout(panelEmail, BoxLayout.X_AXIS));

        JLabel eEmail = new JLabel("Email");
        email = new JTextField();

        panelEmail.add(eEmail);
        panelEmail.add(Box.createHorizontalStrut(10));
        panelEmail.add(email);
        
        return panelEmail; 
    }

    // Panel para los detalles de la reserva
    private JPanel crearPanelDetallesReserva(){
        JPanel panelDetallesReserva = new JPanel();
        panelDetallesReserva.setLayout(new BoxLayout(panelDetallesReserva, BoxLayout.Y_AXIS));
        panelDetallesReserva.setBorder(
            BorderFactory.createTitledBorder("Detalles Reserva")
        );

        panelDetallesReserva.add(crearPanelNumPersonas());
        panelDetallesReserva.add(Box.createVerticalStrut(20));
        panelDetallesReserva.add(crearPanelCategoriaHabitacion());
        panelDetallesReserva.add(Box.createVerticalStrut(20));
        panelDetallesReserva.add(crearPanelEntradaSalida());
        panelDetallesReserva.add(Box.createVerticalStrut(20));
        panelDetallesReserva.add(crearPanelComidas());

        return panelDetallesReserva;
    }

    // Panel para el número de pesonas 
    private JPanel crearPanelNumPersonas(){
        JPanel panelNumPersonas = new JPanel(new BorderLayout());
        panelNumPersonas.setLayout(new BoxLayout(panelNumPersonas, BoxLayout.X_AXIS));

        JLabel eNumPersonas = new JLabel("Número de personas");
        numPersonas = new JTextField();

        panelNumPersonas.add(eNumPersonas);
        panelNumPersonas.add(Box.createHorizontalStrut(10));
        panelNumPersonas.add(numPersonas);
        
        return panelNumPersonas; 
    }

    // Panel para la categoria de la habitación
    private JPanel crearPanelCategoriaHabitacion(){
        JPanel panelCategoriaHabitacion = new JPanel();
        panelCategoriaHabitacion.setLayout(new BoxLayout(panelCategoriaHabitacion, BoxLayout.X_AXIS));

        JLabel eCategorias = new JLabel("Categoria habitación");
        String[] categorias = {"Habitación individual", "Habitación doble", "Habitación triple", "Habitación cuádruple", "Suite"};
        categoriaHabitacion = new JComboBox<String>(categorias);

        panelCategoriaHabitacion.add(eCategorias);
        panelCategoriaHabitacion.add(Box.createHorizontalStrut(10));
        panelCategoriaHabitacion.add(categoriaHabitacion);

        return panelCategoriaHabitacion;
    }

    // Panel para la información de entrada y salida
    private JPanel crearPanelEntradaSalida(){
        JPanel panelEntradaSalida = new JPanel();
        panelEntradaSalida.setLayout(new BoxLayout(panelEntradaSalida, BoxLayout.X_AXIS));

        JLabel eEntrada = new JLabel("Entrada");
        JLabel eSalida = new JLabel("Salida");

        entrada = new JTextField();
        salida = new JTextField();

        panelEntradaSalida.add(eEntrada);
        panelEntradaSalida.add(Box.createHorizontalStrut(10));
        panelEntradaSalida.add(entrada);
        panelEntradaSalida.add(Box.createHorizontalStrut(10));
        panelEntradaSalida.add(eSalida);
        panelEntradaSalida.add(Box.createHorizontalStrut(10));
        panelEntradaSalida.add(salida);

        return panelEntradaSalida;
    }

    // Panel para las opciones de comidas
    private JPanel crearPanelComidas(){
        JPanel panelComidas = new JPanel();
        panelComidas.setLayout(new BoxLayout(panelComidas, BoxLayout.X_AXIS));

        JLabel eComida = new JLabel("Comidas");
        desayuno = new JCheckBox("Desayuno");
        almuerzo = new JCheckBox("Almuerzo");
        cena = new JCheckBox("Cena");

        panelComidas.add(eComida);
        panelComidas.add(Box.createHorizontalStrut(10));
        panelComidas.add(desayuno);
        panelComidas.add(Box.createHorizontalStrut(10));
        panelComidas.add(almuerzo);
        panelComidas.add(Box.createHorizontalStrut(10));
        panelComidas.add(cena);

        return panelComidas;
    }


    // Panel para los botones con las opciones de la reserva
    private JPanel CrearPanelBotones(){
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER));
        
        reiniciar = new JButton("Reiniciar");
        enviar = new JButton("Enviar");
        cancelar = new JButton("Cancelar");

        panelBotones.add(reiniciar);
        panelBotones.add(enviar);
        panelBotones.add(cancelar);

        return panelBotones;
    }
}