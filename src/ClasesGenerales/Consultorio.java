package ClasesGenerales;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultorio {

    // Intancia para acceso global y compartido del objeto
    public static Consultorio instance = new Consultorio();

    ArrayList<Proveedor> proveedores = new ArrayList<>();
    ArrayList<Cita> citas_activas = new ArrayList<>();
    ArrayList<Cita> citas_finalizadas = new ArrayList<>();

    public Consultorio() {
        cargarCitasrArchivo();
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

    public boolean eliminarCitaPorId(int cita_id) {
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
            return true; // confirmar eliminación

        } else {
            return false;
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

    public void cargarCitasrArchivo() {
        String file_path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "temp" +
                            File.separator + "citas.txt";
        
        try (Scanner scan1 = new Scanner(new File(file_path))) {

            while (scan1.hasNextLine()) { // Credenciales admin
                String linea = scan1.nextLine();
                String[] datos = linea.split("\\|");
                String nombres = datos[0].trim().replace(" ", "");
                String apellidos = datos[1].trim().replace(" ", "");
                int edad = Integer.parseInt(datos[2].trim().replace(" ", ""));
                String correo = datos[3].trim().replace(" ", "");
                String tlfno = datos[4].trim().replace(" ", "");
                String motivo = datos[5].trim().replace(" ", "");
                String horario = datos[6].trim().replace(" ", "");
                
                Paciente paciente = new Paciente(nombres, apellidos, correo, tlfno, edad);
                Cita cita = new Cita(motivo, horario, paciente);
                citas_activas.add(cita);
            }

        } catch (FileNotFoundException ex) {
         
        }
    }

    public void guardarCitasArchivo() throws FileNotFoundException, IOException {
        // GUardamos el registro del pago
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src"
                + slice + "temp" + slice + "citas.txt";

        // El archivo no existe, lo creamos y escribimos el contenido
        File file = new File(file_path);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (
                PrintWriter writer = new PrintWriter(file_path)) {
            for (Cita cita : citas_activas) {
                // Paciente{nombres, apellidos, edad, correo, telefono}, motivo, horario
                writer.append(cita.getPaciente().getNombres() + "|" + cita.getPaciente().getApellidos()
                        + "|" + cita.getPaciente().getEdad() + "|" + cita.getPaciente().getCorreo()
                        + "|" + cita.getPaciente().getTlfno() + "|" + cita.getMotivo() + "|"
                        + cita.getHorario() + "\n");
            }
        }

    }

    public void setCitasActivas(ArrayList<Cita> citas) {
        this.citas_activas = citas;
    }

}
