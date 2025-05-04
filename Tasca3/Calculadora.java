public class Calculadora implements ModeloCalculadora{
    private double resultado;
    private OperadorBinario operacion;

    public Calculadora(){
        this.resultado = 0;
        this.operacion = null;
    }
    @Override
    public void clear() {
        this.resultado = 0;
        this.operacion = null;
    }

    @Override
    public double getResultado() {
        return resultado;
    }

    @Override
    public void nuevaOperacion(OperadorBinario operacion) {
        this.operacion = operacion;
    }

    @Override
    public void nuevoOperando(double operando) {
        if(this.operacion != null){
            this.resultado = operacion.ejecutar(resultado, operando);
        }

        else{
            this.resultado = operando;
        }

        this.operacion = null;
    }
    
}
