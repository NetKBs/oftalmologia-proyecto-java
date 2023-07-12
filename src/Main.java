
import java.io.File;

public class Main {

    public static void main(String[] args) {
        String slice = File.separator;
        String file_path = System.getProperty("user.dir") + slice + "src" + slice + "temp";
        
       
        File adminFile = new File(file_path + slice + "admin.txt");
        File docFile = new File(file_path + slice + "doc.txt");

        //Verificar si existe la carpeta temp
        if (!new File(file_path).exists()) {
            new File(file_path).mkdirs();
        }
        
        if (!adminFile.exists()) { // credenciales de administrador
            CrearAdminUser crear_admin = new CrearAdminUser();
            crear_admin.setVisible(true);
            
        } else if (!docFile.exists()) { // credenciales de doctor
            CrearDocUser crear_doctor = new CrearDocUser();
            crear_doctor.setVisible(true);
       
        } else { // Mandar a loguear
            LoginAdmin login = new LoginAdmin();
            login.setVisible(true);
        }
            
       
       
    }
    

}
