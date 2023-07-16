package ClasesGenerales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Consultorio {

    // Intancia para acceso global y compartido del objeto
    public static Consultorio instance = new Consultorio();

    private ArrayList<Proveedor> proveedores = new ArrayList<>();
    private ArrayList<Cita> citas_activas = new ArrayList<>();
    private ArrayList<Cita> citas_finalizadas = new ArrayList<>();
    // materiales, pacientes, gastos, pagos
    private int[] actividades_m = {0, 0, 0, 0};
    private int[] actividades_s ={0, 0, 0, 0};

    public Consultorio() {
        cargarCitasrArchivo();
        cargarActividades();

    }

    public int[] getActividades_m() {
        return actividades_m;
    }

    public int[] getActividades_s() {
        return actividades_s;
    }

    //Guardados de actividades
    public void guardadoActividades(String archivo) throws IOException {
        // GUardamos el registro del pago
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src"
                + slice + "temp" + slice + archivo + ".txt";

        LocalDate today = LocalDate.now();

        int day = today.getDayOfMonth();
        int month = today.getMonthValue();
        int year = today.getYear();

        // El archivo no existe, lo creamos y escribimos el contenido
        File file = new File(file_path);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(file_path, true))) {

            writer.append(day + "|" + month + "|" + year + "\n");
            writer.close();

        }

    }

    public void cargarActividades() {

        String filePath = System.getProperty("user.dir") + File.separator + "src"
                + File.separator + "temp" + File.separator;
        String[] files = {filePath + "material_recibido.txt", filePath + "pacientes_atendidos.txt",
            filePath + "gastos_realizados.txt", filePath + "cantidad_pagos.txt"};

        for (int i = 0; i < files.length; i++) {

            File file = new File(files[i]);

            if (!file.exists()) {
                // Crea el archivo si no existe
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Leer archivo y sumar valores 
            try {
                List<String> lines = Files.readAllLines(Paths.get(files[i]));

                for (String line : lines) {
                    String[] split = line.split("\\|");

                    if (split[0].isEmpty()) {
                        continue;  // Salta esta línea vacía
                    }

                    int dia = Integer.parseInt(split[0]);
                    int mes = Integer.parseInt(split[1]);
                    int anio = Integer.parseInt(split[2]);

                    // Verificamos si es semanal o mensual
                    LocalDate today = LocalDate.now();
                    // La fecha dada 
                    LocalDate givenDate = LocalDate.of(anio, mes, dia);
                    // Calcular la diferencia en días 
                    long daysBetween = ChronoUnit.DAYS.between(givenDate, today);

                    if (daysBetween > 0 && daysBetween <= 7) {
                        actividades_s[i] += 1;
               
                    } else if (daysBetween > 7 && daysBetween <= 30) {
                        actividades_m[i] += 1;
             
                    }

                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Doctor datos
    // Proveedores
    public void agregarProveedor(Proveedor proveedor) {
        this.proveedores.add(proveedor);
    }

    public boolean eliminarProveedor(String empresa) {
        int index = -1;

        // Verificar si existe
        for (int i = 0; i < proveedores.size(); i++) {
            if (proveedores.get(i).getEmpresa().toLowerCase().equals(empresa.toLowerCase())) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            // Sólo eliminar si existe
            this.proveedores.remove(index);
            return true; // confirmar eliminación

        } else {
            return false;
        }

    }

    public ArrayList<Proveedor> getProveedores() {
        return proveedores;
    }

    public void guardarProveedoresArchivo() throws FileNotFoundException, IOException {
        // GUardamos el registro del pago
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src"
                + slice + "temp" + slice + "proveedores.txt";

        // El archivo no existe, lo creamos y escribimos el contenido
        File file = new File(file_path);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (
                PrintWriter writer = new PrintWriter(file_path)) {
            for (Proveedor proveedor : proveedores) {
                // Paciente{nombres, apellidos, edad, correo, telefono}, motivo, horario
                writer.append(proveedor.getEmpresa() + "|" + proveedor.getLista_productos() + "|" + proveedor.getFecha_entrega());

            }
            writer.close();
        }

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
        String file_path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "temp"
                + File.separator + "citas.txt";

        try (Scanner scan1 = new Scanner(new File(file_path))) {

            while (scan1.hasNextLine()) { // Credenciales admin
                String linea = scan1.nextLine();
                String[] datos = linea.split("\\|");
                String nombres = datos[0].trim();
                String apellidos = datos[1].trim();
                int edad = Integer.parseInt(datos[2].trim());
                String correo = datos[3].trim();
                String tlfno = datos[4].trim();
                String motivo = datos[5].trim();
                String horario = datos[6].trim();

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
            writer.close();
        }

    }

    public void setCitasActivas(ArrayList<Cita> citas) {
        this.citas_activas = citas;
    }

}
