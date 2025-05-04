import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.Locale;

public class ControladorCalculadora {
    private VistaCalculadora vista;
    private ModeloCalculadora modelo;
    private boolean puntoDecimal;
    private boolean editandoValor;
    private NumberFormat numberFormat;

    public ControladorCalculadora(VistaCalculadora vista, ModeloCalculadora modelo){
        this.vista = vista;
        this.modelo = modelo;
        puntoDecimal = false;
        editandoValor = false;

        for(int i = 0; i < 10; i++){
            final String d = Integer.toString(i);
            vista.addOyenteTeclaDigito(i, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    teclaDigitoPulsada(d);
                }
            });
        }

        vista.addOyenteTeclaClear(new ActionListener() { 
            public void actionPerformed(ActionEvent event) { 
                teclaClearPulsada(); 
            } 
           });

        vista.addOyenteTeclaDecimal(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaDecimalPulsada();
            }
        });

        vista.addOyenteTeclaDiv(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaDivPulsada();
            }
        });

        vista.addOyenteTeclaDiv(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaDivPulsada();
            }
        });

        vista.addOyenteTeclaIgual(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaIgualPulsada();
            }
        });

        vista.addOyenteTeclaMas(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaMasPulsada();
            }
        });

        vista.addOyenteTeclaMenos(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaMenosPulsada();
            }
        });

        vista.addOyenteTeclaPor(new ActionListener() {
            public void actionPerformed(ActionEvent event){
                teclaPorPulsada();
            }
        });

        numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setMaximumFractionDigits(10);
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setGroupingUsed(false);
    }

    private void nuevaOperacion(OperadorBinario operador){
        if(editandoValor){
            modelo.nuevoOperando(Double.parseDouble(vista.getDisplay()));
        }
        modelo.nuevaOperacion(operador);
        editandoValor = false;
        puntoDecimal = false;
        vista.setDisplay(numberFormat.format(modelo.getResultado()));
    }
    protected void teclaMasPulsada() {
        nuevaOperacion(new Suma());
    } 
    protected void teclaMenosPulsada() {
        nuevaOperacion(new Resta());
    } 
    protected void teclaPorPulsada() {
        nuevaOperacion(new Multiplicacion());
    } 
    protected void teclaDivPulsada(){
        nuevaOperacion(new Division());
    } 
    protected void teclaIgualPulsada(){
        if(editandoValor){
            modelo.nuevoOperando(Double.parseDouble(vista.getDisplay()));
        }
        vista.setDisplay(numberFormat.format(modelo.getResultado()));
        editandoValor = false;
        puntoDecimal = false;
        
    } 
    protected void teclaClearPulsada(){
        modelo.clear();
        vista.setDisplay(numberFormat.format(modelo.getResultado()));
        editandoValor = false;
        puntoDecimal = false;
    } 

    protected void teclaDigitoPulsada(String digito) {
        String display = vista.getDisplay();
        if(display.equals("0") || !editandoValor){
            vista.setDisplay(digito);
            editandoValor = true;
        }
        else {
            vista.setDisplay(display + digito);
        }
    }  
    protected void teclaDecimalPulsada(){
        if(!puntoDecimal){
            String display = vista.getDisplay();
            if(editandoValor){
                vista.setDisplay(display + ".");
            }
            else{
                vista.setDisplay("0.");
                editandoValor = true;
            }
        }
        puntoDecimal = true;
    }
    }
