package ClasesGenerales;

public class Pago {
    private String metodo;
    private Cita cita;
    
    public Pago(String metodo, Cita cita) {
        this.metodo = metodo;
        this.cita = cita;
    }

    public String getMetodo() {
        return metodo;
    }
    public Cita getCita() {
        return cita;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }
    public void setCita(Cita cita) {
        this.cita = cita;
    }
    
    public boolean procesarPago() {
        return false;
    }
    
}
