public class ListaEnlazada {

    Nodo inicio;

    public ListaEnlazada() {
        inicio = null;
    }

    public void insertar(Alumno alumno) {

        Nodo nuevo = new Nodo(alumno);

        if (inicio == null) {
            inicio = nuevo;
        } else {
            Nodo aux = inicio;

            while (aux.siguiente != null) {
                aux = aux.siguiente;
            }

            aux.siguiente = nuevo;
        }
    }
}