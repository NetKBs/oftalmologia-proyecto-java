
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
        
        if (!adminFile.exists() || !adminFile.exists()) {
            
        }
       
    }
    

}
