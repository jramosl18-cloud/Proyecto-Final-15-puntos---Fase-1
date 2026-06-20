public class Alumno {

    long carnet;
    String nombre;
    String curso;
    String seccion;
    double nota;

    public Alumno(long carnet, String nombre,
                  String curso, String seccion,
                  double nota) {

        this.carnet = carnet;
        this.nombre = nombre;
        this.curso = curso;
        this.seccion = seccion;
        this.nota = nota;
    }
}