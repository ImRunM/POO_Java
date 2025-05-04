import javax.swing.SwingUtilities;

public class AplicacionCalculadora {
    public static void main(String[] args) {
        VentanaCalculadora calculadora = new VentanaCalculadora("Calculadora");
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                calculadora.setVisible(true);
            }
        });
    }
}
