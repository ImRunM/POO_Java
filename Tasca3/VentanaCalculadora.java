import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaCalculadora extends JFrame implements VistaCalculadora{
    private JTextField display;
    private JButton clear;
    private JButton[] numeros; 
    private JButton puntoDecimal, igual, suma, resta, multiplicacion, division;

    public VentanaCalculadora(){
        super();
        this.init();
    }
    
    public VentanaCalculadora(String title){
        super(title);
        this.init();
    }
    private void init(){
        this.setSize(270, 270);
        this.setLocation(100, 200);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);;

        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(crearPanelDisplay(), BorderLayout.NORTH);
        p1.add(crearPanelClear(), BorderLayout.CENTER);
        p1.add(crearPanelTeclas(), BorderLayout.SOUTH);
        this.setContentPane(p1);
    }

    private JPanel crearPanelDisplay(){
        JPanel panelDisplay = new JPanel();
        display = new JTextField("0", 10);
        display.setBorder(
            BorderFactory.createLineBorder(Color.LIGHT_GRAY, 1, true)
        );
        display.setBackground(Color.WHITE);
        display.setFont(new Font("Arial", Font.BOLD,25));
        display.setHorizontalAlignment(JTextField.RIGHT);
        display.setEditable(false);

        panelDisplay.add(display);
        return panelDisplay;
    }

    private JPanel crearPanelClear(){
        JPanel panelClear = new JPanel(new FlowLayout(FlowLayout.RIGHT)); 
        clear = new JButton("C");
        clear.setBackground(Color.RED);
        clear.setForeground(Color.WHITE);

        panelClear.add(clear);
        return panelClear;
    }

    private JPanel crearPanelTeclas(){
        JPanel panelTeclas = new JPanel(new GridLayout(4, 4, 5, 5));
        panelTeclas.setBorder(BorderFactory.createEmptyBorder(4, 4, 4, 4));

        numeros = new JButton[10];
        for(int i= 0; i<= 9; i++){
            numeros[i] = new JButton(String.valueOf(i));
        }

        puntoDecimal = new JButton(".");
        igual = new JButton("=");
        suma = new JButton("+");
        resta = new JButton("-");
        multiplicacion = new JButton("*");
        division = new JButton("/");

        panelTeclas.add(numeros[7]);
        panelTeclas.add(numeros[8]);
        panelTeclas.add(numeros[9]);
        panelTeclas.add(division);

        panelTeclas.add(numeros[4]);
        panelTeclas.add(numeros[5]);
        panelTeclas.add(numeros[6]);
        panelTeclas.add(multiplicacion);

        panelTeclas.add(numeros[1]);
        panelTeclas.add(numeros[2]);
        panelTeclas.add(numeros[3]);
        panelTeclas.add(resta);

        panelTeclas.add(numeros[0]);
        panelTeclas.add(puntoDecimal);
        panelTeclas.add(igual);
        panelTeclas.add(suma);

        return panelTeclas;
    }

    @Override
    public void setDisplay(String s) {
        display.setText(s);
    }

    @Override
    public String getDisplay() {
        return display.getText();
    }

    @Override
    public void addOyenteTeclaDigito(int digito, ActionListener l) {
        numeros[digito].addActionListener(l);
    }

    @Override
    public void addOyenteTeclaDecimal(ActionListener l) {
        puntoDecimal.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaMas(ActionListener l) {
        suma.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaMenos(ActionListener l) {
        resta.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaPor(ActionListener l) {
        multiplicacion.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaDiv(ActionListener l) {
        division.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaIgual(ActionListener l) {
        igual.addActionListener(l);
    }

    @Override
    public void addOyenteTeclaClear(ActionListener l) {
        clear.addActionListener(l);
    }
}