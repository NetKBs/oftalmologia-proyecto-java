
package ClasesGenerales;

public class Paciente {
    private String nombres; // nombre1, nombre2
    private String apellidos; // apellido1, apellido2
    private String correo;
    private String tlfno;
    private int edad;

    public Paciente(String nombres, String apellidos, String correo, String tlfno, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.tlfno = tlfno;
        this.edad = edad;
    }
    
    // Getters
    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }


    public String getCorreo() {
        return correo;
    }

    public String getTlfno() {
        return tlfno;
    }

    public int getEdad() {
        return edad;
    }
    
    // Setters
    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTlfno(String tlfno) {
        this.tlfno = tlfno;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
     
}



