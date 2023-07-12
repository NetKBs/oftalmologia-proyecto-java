package ClasesGenerales;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Pago {

    private String metodo;
    private String moneda;
    private int cita_id;
    private int monto;
    private String ref;

    public Pago(String metodo, String moneda, int cita_id, int monto, String ref) {
        this.metodo = metodo;
        this.cita_id = cita_id;
        this.moneda = moneda;
        this.monto = monto;
        this.ref = ref;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
    
    
    
    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public String getMetodo() {
        return metodo;
    }

    public int getCitaId() {
        return cita_id;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setCitaId(int cita_id) {
        this.cita_id = cita_id;
    }

    public boolean procesarPago() throws FileNotFoundException, IOException {
        // Buscar Cita con respecto a id
        ArrayList<Cita> citas = Consultorio.instance.getCitas_activas();
        int index = -1;

        for (Cita cita : citas) {
            if (cita.getId() == cita_id) {
                index = citas.indexOf(cita);
                break;
            }
        }

        if (index != -1) { // Se ha encontrado
            citas.get(index).setEstado(true); // verificar pago
            Consultorio.instance.setCitasActivas(citas);

            // GUardamos el registro del pago
            String slice = File.separator;
            String file_path = System.getProperty("user.dir") + slice + "src" + 
                                             slice + "temp" + slice + "ingresos.txt";
      

            // Primero, revisamos si el archivo existe
            File file = new File(file_path);
            if (file.exists()) {
                // El archivo existe, lo abrimos para agregar contenido
                PrintWriter writer = new PrintWriter(new FileWriter(file_path, true));
                writer.append(ref + "|" + moneda + "|" + monto + "|" + metodo + "|" + cita_id + "\n");
                writer.close();
            } else {
                // El archivo no existe, lo creamos y escribimos el contenido
                PrintWriter writer = new PrintWriter(file_path);
                writer.append(ref + "|" + moneda + "|" + monto + "|" + metodo + "|" + cita_id + "\n");
                writer.close();
               
            }

            return true;

        } else {
            return false;
        }

    }

}
