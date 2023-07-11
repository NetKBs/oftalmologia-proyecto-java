
package ClasesGenerales;

abstract class Persona {
    private String[] nombres; // nombre1, nombre2
    private String[] apellidos; // apellido1, apellido2
    private String f_nacimiento; // dd/mm/yy
    private String correo;
    private String tlfno;
    private int edad;

    public Persona(String[] nombres, String[] apellidos, String f_nacimiento, String correo, String tlfno, int edad) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.f_nacimiento = f_nacimiento;
        this.correo = correo;
        this.tlfno = tlfno;
        this.edad = edad;
    }
    
    // Getters
    public String[] getNombres() {
        return nombres;
    }

    public String[] getApellidos() {
        return apellidos;
    }

    public String getF_nacimiento() {
        return f_nacimiento;
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
    public void setNombres(String[] nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String[] apellidos) {
        this.apellidos = apellidos;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
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

class Doctor extends Persona {
    private String universidad;
    private String especializacion;

    public Doctor(String universidad, String especializacion, String[] nombres, String[] apellidos, String f_nacimiento, String correo, String tlfno, int edad) {
        super(nombres, apellidos, f_nacimiento, correo, tlfno, edad);
        this.universidad = universidad;
        this.especializacion = especializacion;
    }

    public String getUniversidad() {
        return universidad;
    }
    public String getEspecializacion() {
        return especializacion;
    }

    public void setEspecializacion(String especializacion) {
        this.especializacion = especializacion;
    }
    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }
    
}

class Cliente extends Persona{
    private String cedula;
    private String direccion;

    public Cliente(String cedula, String direccion, String[] nombres, String[] apellidos, String f_nacimiento, String correo, String tlfno, int edad) {
        super(nombres, apellidos, f_nacimiento, correo, tlfno, edad);
        this.cedula = cedula;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    
}

