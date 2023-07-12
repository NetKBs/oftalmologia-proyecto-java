package ClasesGenerales;

import java.util.ArrayList;

public class Consultorio {
    Doctor doctor;
    ArrayList<Proveedor> proveedores = new ArrayList<>();
    ArrayList<Cita> citas_activas = new ArrayList<>();
    ArrayList<Cita> citas_finalizadas = new ArrayList<>();
    
    public Consultorio() {
        
    }
    
    // Doctor datos
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    public Doctor getDoctor() {
        return doctor;
    }
    
    // Proveedores
    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }
    public void eliminarProveedor(Proveedor proveedor) {
        this.proveedores.remove(proveedor);
    }
    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }
    
    // Citas
    public void agregarCita(Cita cita) {
        this.citas_activas.add(cita);
    }
    public void eliminarCita(Cita cita) {
        this.citas_activas.remove(cita);
    }
    // Para confirmar una cita 
    public void procesarCita(Cita cita) {
        
    }
    
    public ArrayList<Cita> getCitas_activas() {
        return citas_activas;
    }
    public ArrayList<Cita> getCitas_finalizadas() {
        return citas_finalizadas;
    }
    
 
}
