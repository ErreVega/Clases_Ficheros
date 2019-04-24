package Clases;

public class Nodo {
    private Contacto contacto;
    private Nodo siguiente;
    private Nodo anterior;
    

    public Nodo(Contacto contacto) {
        this.contacto = contacto;
    }

    public Nodo(Nodo otro){
        this.contacto = otro.contacto;
        this.anterior = otro.anterior;
        this.siguiente = otro.siguiente;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
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
    
    public boolean comparaContacto(String s){
        boolean igual = false;
        s = s.toLowerCase();
        if (this.getContacto().getNombre().toLowerCase().contains(s))
            igual = true;
        else if (this.getContacto().getApellido().toLowerCase().contains(s))
            igual = true;
        else if (this.getContacto().getMail().toLowerCase().contains(s))
            igual = true;
        else {
            String telefono = "" + this.getContacto().getTelefono();
            if (telefono.contains(s))
                igual = true;
        }
        return igual;
    }
    
}
