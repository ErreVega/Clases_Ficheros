package Clases;

public class Lista {
    private Nodo primero;

    public Lista(Nodo primero) {
        this.primero = primero;
    }

    public Lista() {
    }

    public void insertar(Nodo nodo) {

        if (this.primero == null){
            this.primero = nodo;
        } else {
            Nodo iNodo = this.primero;

            while (iNodo.getSiguiente() != null) {
                iNodo = iNodo.getSiguiente();
            }
            iNodo.setSiguiente(nodo);
            nodo.setAnterior(iNodo);
        }
    }

    public void insertar(Alumno a) {
        Nodo nuevo = new Nodo(a);
        insertar(nuevo);
    }


    public void borrar(Nodo nodo){
        if (this.primero != null) {
            if (this.primero.getAlumno().equals(nodo.getAlumno())){
                this.primero.getSiguiente().setAnterior(null);
                this.primero = this.primero.getSiguiente();
            } else {
                Nodo iNodo = this.primero;
                while (iNodo != null) {
                    if (iNodo.getAlumno().equals(nodo.getAlumno())) {
                        try {
                            iNodo.getAnterior().setSiguiente(iNodo.getSiguiente());
                        } catch (NullPointerException e) {
                        }
                        try {
                            iNodo.getSiguiente().setAnterior(iNodo.getAnterior());
                        } catch (NullPointerException e) {
                        }
                        iNodo = null;
                    } else
                        iNodo = iNodo.getSiguiente();
                }
            }
        }
    }
    
    public void borrar(Alumno a) {
        Nodo nodo = new Nodo(a);
        borrar(nodo);
    }


    public String toString() {
        String r = "\n";
        Nodo iNodo = new Nodo(this.primero);
        while (iNodo != null) {
            r = r + iNodo.getAlumno().toString() + "\n _ _ _ _ _ _\n";
            iNodo = iNodo.getSiguiente();
        }

        return r;

    }
}
