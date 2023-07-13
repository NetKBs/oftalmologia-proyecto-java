package ClasesGenerales;

import java.util.ArrayList;


public class Proveedor {
    private String empresa;
    private String fecha_entrega;
    private String productos;

    public Proveedor(String empresa, String fecha_entrega, String productos) {
        this.empresa = empresa;
        this.fecha_entrega = fecha_entrega;
        this.productos = productos;
    }

    public String getEmpresa() {
        return empresa;
    }
    public String getFecha_entrega() {
        return fecha_entrega;
    }
    public String getLista_productos() {
        return productos;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }
    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }
 
    // Agregar productos a lista_productos
    public void setProductos(String producto) {
        this.productos = producto;
    }
  
}
