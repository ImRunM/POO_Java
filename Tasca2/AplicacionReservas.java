import javax.swing.SwingUtilities;

public class AplicacionReservas {
    public static void main(String[] args) {
        VentanaReservas reservas = new VentanaReservas("Reservas");
        SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                reservas.setVisible(true);
            }
        });
    }
}
