import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class Menu {

    Scanner sc = new Scanner(System.in);
    String rutaArchivo = "";
    ListaEnlazada lista = new ListaEnlazada();

    public void iniciar() {

        int opcion;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Cargar archivo");
            System.out.println("2. Mostrar alumnos");
            System.out.println("3. Promedio general");
            System.out.println("4. Salir");

            System.out.print("Seleccione: ");
            opcion = sc.nextInt();

            switch(opcion) {

                case 1:
                    cargarArchivo();
                    break;

                case 2:
                    mostrarAlumnos();
                    break;

                case 3:
                    promedio();
                    break;

                case 4:
                    System.out.println("Programa finalizado");
                    break;

                default:
                    System.out.println("Opcion invalida");
            }

        } while(opcion != 4);
    }

    private void cargarArchivo() {

        sc.nextLine();

        System.out.print("Ingrese ruta del archivo: ");
        rutaArchivo = sc.nextLine();

        try {

            lista = new ListaEnlazada();

            BufferedReader br = new BufferedReader(new FileReader(rutaArchivo));

            String linea;

            while ((linea = br.readLine()) != null) {

                String datos[] = linea.split(",");

                Alumno alumno = new Alumno(
                        Long.parseLong(datos[0].trim()),
                        datos[1].trim(),
                        datos[2].trim(),
                        datos[3].trim(),
                        Double.parseDouble(datos[4].trim())
                );

                lista.insertarFinal(alumno);
            }

            br.close();

            System.out.println("Datos cargados correctamente");

        } catch(Exception e) {
            System.out.println("Error al cargar archivo");
        }
    }

    private void mostrarAlumnos() {

        Nodo aux = lista.getInicio();

        if(aux == null) {
            System.out.println("No hay alumnos cargados");
            return;
        }

        System.out.println("\nLISTA DE ALUMNOS");

        while(aux != null) {

            System.out.println(
                aux.alumno.getCarnet() + " - " +
                aux.alumno.getNombre() + " - " +
                aux.alumno.getNota()
            );

            aux = aux.siguiente;
        }
    }

    private void promedio() {

        Nodo aux = lista.getInicio();

        double suma = 0;
        int cont = 0;

        while(aux != null) {

            suma += aux.alumno.getNota();
            cont++;
            aux = aux.siguiente;
        }

        if(cont > 0) {
            System.out.println("Promedio: " + (suma / cont));
        } else {
            System.out.println("No hay datos");
        }
    }
}