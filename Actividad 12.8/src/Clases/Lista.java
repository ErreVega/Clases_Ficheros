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

    public void insertar(Contacto a) {
        Nodo nuevo = new Nodo(a);
        insertar(nuevo);
    }


    public boolean borrar(Nodo nodo) {
        boolean borrado = false;
        if (this.primero != null) {
            if (this.primero.getContacto().equals(nodo.getContacto())) {
                this.primero.getSiguiente().setAnterior(null);
                this.primero = this.primero.getSiguiente();
                borrado = true;
            } else {
                Nodo iNodo = this.primero;
                while (iNodo != null) {
                    if (iNodo.getContacto().equals(nodo.getContacto())) {
                        try {
                            iNodo.getAnterior().setSiguiente(iNodo.getSiguiente());
                        } catch (NullPointerException e) {
                        }
                        try {
                            iNodo.getSiguiente().setAnterior(iNodo.getAnterior());
                        } catch (NullPointerException e) {
                        }
                        iNodo = null;
                        borrado = true;
                    } else
                        iNodo = iNodo.getSiguiente();
                }
            }
        }
        return borrado;
    }

    public boolean borrar(Contacto a) {
        Nodo nodo = new Nodo(a);
        return borrar(nodo);
    }

    public Lista busca(String s) {
        Lista respuesta = new Lista();
        if (this.primero != null) {
            Nodo iNodo = this.primero;
            while (iNodo != null) {
                if (iNodo.comparaContacto(s)) {
                    respuesta.insertar(iNodo.getContacto());
                }
                try {
                    iNodo = iNodo.getSiguiente();
                } catch (NullPointerException e) {
                }
            }
        }
        return respuesta;
    }


    public void ordena() {    // El metodo no mueve los nodos, solamente intercambia la informacion del alumno entre ellos para que queden ordenados
        Nodo iNodo = this.primero;
        Boolean ordenado,
                fin = false;

        do {
            ordenado = true;
            String ape1 = iNodo.getContacto().getApellido();  //almacenamos los apellidos del Nodo iterado y del siguiente para trabajar mas comodamente
            try {
                String apeSig = iNodo.getSiguiente().getContacto().getApellido();

                if (ape1.equalsIgnoreCase(apeSig)) {  //si los apellidos son iguales se pasa a evaluar los nombres de la misma manera
                    String nombre1 = iNodo.getContacto().getNombre();
                    String nombreSig = iNodo.getSiguiente().getContacto().getNombre();

                    if (nombre1.compareToIgnoreCase(nombreSig) < 0 == false) { //en el caso de que no esten en el orden correcto se intercambian los alumnos de nodo
                        Contacto aux = iNodo.getSiguiente().getContacto();
                        iNodo.getSiguiente().setContacto(iNodo.getContacto());
                        iNodo.setContacto(aux);
                        ordenado = false; // si no hay ningun cambio, la lista esta ordenada y acaba el bucle
                    }
                } else if (ape1.compareToIgnoreCase(apeSig) < 0 == false) { //en el caso de que no esten en el orden correcto se intercambian los alumnos de nodo
                    Contacto aux = iNodo.getSiguiente().getContacto();
                    iNodo.getSiguiente().setContacto(iNodo.getContacto());
                    iNodo.setContacto(aux);
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

    public Contacto getContacto(int i) {
        int cont = 1;
        Contacto respuesta = null;
        if (this.primero != null) {
            Nodo iNodo = this.primero;
            while (iNodo != null && cont <= i) {
                if (cont == i) {
                    respuesta = iNodo.getContacto();
                    iNodo = null;
                } else {
                    cont++;
                    iNodo = iNodo.getSiguiente();
                }
            }
        }
        return respuesta;
    }


    public String toString() {
        String r = "Lista vacia.";
        if (this.primero != null) {
            r = "\n";
            Nodo iNodo = new Nodo(this.primero);
            int cont = 1;
            while (iNodo != null) {
                r = r + cont + ". _ _ _ _ _" +
                        "\n\tNombre: " + iNodo.getContacto().getNombre() +
                        "\n\tApellidos: " + iNodo.getContacto().getApellido() +
                        "\n\tTelefono: " + iNodo.getContacto().getTelefono() +
                        "\n\tEmail: " + iNodo.getContacto().getMail() +
                        "\n\n";

                iNodo = iNodo.getSiguiente();
                cont++;
            }
        }

        return r;

    }


}
