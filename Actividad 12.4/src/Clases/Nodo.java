package Clases;

public class Nodo {
    private Alumno alumno;
    private Nodo siguiente;
    private Nodo anterior;

    public Nodo(Alumno alumno) {
        this.alumno = alumno;
    }

    public Nodo (Nodo otro){
        this.alumno = otro.alumno;
        this.anterior = otro.anterior;
        this.siguiente = otro.siguiente;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}
