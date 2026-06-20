import java.io.BufferedReader;
import java.io.FileReader;

public class ArchivoUtil {

    public static void mostrarArchivo(String ruta) {

        try {

            BufferedReader br = new BufferedReader(new FileReader(ruta));

            String linea;

            while (linea = br.readLine()) != null {
                System.out.println(linea);
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error al leer el archivo");
        }
    }
}