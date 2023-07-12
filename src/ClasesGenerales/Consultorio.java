package ClasesGenerales;

import java.util.ArrayList;

public class Consultorio {

    // Intancia para acceso global y compartido del objeto
    public static Consultorio instance = new Consultorio();

    ArrayList<Proveedor> proveedores = new ArrayList<>();
    ArrayList<Cita> citas_activas = new ArrayList<>();
    ArrayList<Cita> citas_finalizadas = new ArrayList<>();

    public Consultorio() {

    }

    // Doctor datos
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

    public void eliminarCitaPorId(int cita_id) {
        int index = -1;
        // Verificar si existe
        for (int i = 0; i < citas_activas.size(); i++) {
            if (citas_activas.get(i).getId() == cita_id) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Sólo eliminar si existe
            this.citas_activas.remove(index);
        }
        
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

    public void setCitasActivas(ArrayList<Cita> citas) {
        this.citas_activas = citas;
    }

}
