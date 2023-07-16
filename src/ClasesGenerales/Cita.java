package ClasesGenerales;

public class Cita {

    private static int nextId = 1;
    private int id;
    
    private String motivo;
    private String horario; // dd/mm/yy-hh/mm
    private Paciente paciente;
    private boolean estado = false; // pago o no
    private String historia;
    private String informe;
    
    public Cita(String motivo, String horario, Paciente paciente) {
        this.id = nextId;
        nextId++;
        
        this.motivo = motivo;
        this.horario = horario;
        this.paciente = paciente;
    }

    public int getId() {
        return id;
    }

    public String getMotivo() {
        return motivo;
    }
    
    public String getHorario() {
        return horario;
    }
    
     public Paciente getPaciente() {
        return paciente;
    }
    
    public boolean getEstado() {
        return estado;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
    public void setHorario(String horario) {
        this.horario = horario;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
