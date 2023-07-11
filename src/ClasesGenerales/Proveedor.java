package ClasesGenerales;

import java.util.ArrayList;


public class Proveedor {
    private String empresa;
    private String fecha_entrega;
    private ArrayList<String> lista_productos;

    public Proveedor(String empresa, String fecha_entrega, ArrayList<String> lista_productos) {
        this.empresa = empresa;
        this.fecha_entrega = fecha_entrega;
        this.lista_productos = lista_productos;
    }

    public String getEmpresa() {
        return empresa;
    }
    public String getFecha_entrega() {
        return fecha_entrega;
    }
    public ArrayList<String> getLista_productos() {
        return lista_productos;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
    public void setLista_productos(ArrayList<String> lista_productos) {
        this.lista_productos = lista_productos;
    }
    
}
