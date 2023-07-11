package ClasesGenerales;

public class Pago {
    String metodo;
    Cita cita;
    
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
    
}
