package Clases;

public class Lista {
    private Nodo primero;

    public Lista(Nodo primero) {
        this.primero = primero;
    }

    public Lista() {
    }

    public void insertar(Nodo nodo) {

        if (this.primero == null) {
            this.primero = nodo;
        } else {
            Nodo iNodo = this.primero;

            while (iNodo.getSiguiente() != null) {
                iNodo = iNodo.getSiguiente();
            }
            iNodo.setSiguiente(nodo);
            nodo.setAnterior(iNodo);
            this.ordena();
        }
    }

    public void insertar(Alumno a) {
        Nodo nuevo = new Nodo(a);
        insertar(nuevo);
    }


    public void borrar(Nodo nodo) {
        if (this.primero != null) {
            if (this.primero.getAlumno().equals(nodo.getAlumno())) {
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

    public void ordena() {    // El metodo no mueve los nodos, solamente intercambia la informacion del alumno entre ellos para que queden ordenados
        Nodo iNodo = this.primero;
        Boolean ordenado,
                fin = false;

        do {
            ordenado = true;
            String ape1 = iNodo.getAlumno().getApellidos();  //almacenamos los apellidos del Nodo iterado y del siguiente para trabajar mas comodamente
            try {
                String apeSig = iNodo.getSiguiente().getAlumno().getApellidos();

                if (ape1.compareToIgnoreCase(apeSig) < 0 == false) { //en el caso de que no esten en el orden correcto se intercambian los alumnos de nodo
                    Alumno aux = iNodo.getSiguiente().getAlumno();
                    iNodo.getSiguiente().setAlumno(iNodo.getAlumno());
                    iNodo.setAlumno(aux);
                    ordenado = false; // si no hay ningun cambio, la lista esta ordenada y acaba el bucle
                }
                if (ordenado) // si la lista esta ordenada hasta ahora,
                    iNodo = iNodo.getSiguiente(); //se itera al siguiente nodo
                else
                    iNodo = this.primero; // si no se vuelve al principio para comprobar los cambios
            } catch (NullPointerException e) {
                fin = true; // Si el nodo siguiente es nulo y salta la excepcion acaba el bucle
            }
        } while (!ordenado || !fin);

    }

    public void borrar(Alumno a) {
        Nodo nodo = new Nodo(a);
        borrar(nodo);
    }


    public String toString() {
        String r = "\n";
        Nodo iNodo = new Nodo(this.primero);
        while (iNodo != null) {
            r = r + iNodo.getAlumno().toString() + "\n _ _ _ _ _ _\n\n";
            iNodo = iNodo.getSiguiente();
        }

        return r;

    }

    public String toStringNombre() {
        String r = "\n";
        Nodo iNodo = new Nodo(this.primero);
        while (iNodo != null) {
            r = r + iNodo.getAlumno().toStringNombreApe() + "\n _ _ _ _ _ _\n\n";
            iNodo = iNodo.getSiguiente();
        }

        return r;

    }


}
