package Main;

import Clases.Contacto;
import Clases.FicheroToLista;
import Clases.Lista;
import Clases.ListaToFichero;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main12_8 {
    public static void main(String[] args) {

        File f = new File("agenda.txt");
        Lista lista = new Lista();
        FicheroToLista ftl = new FicheroToLista(f);
        try {
            ftl.toLista(lista);
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no existe. No se ha cargado ninguna lista anterior.\n");
        }
        Scanner sc = new Scanner(System.in);

        String menu = (
                "Seleccione opcion:" +
                        "\n1.Consultar agenda" +
                        "\n2.Agregar Contacto" +
                        "\n3.Borrar Contacto" +
                        "\n4.Buscar Contacto" +
                        "\n5.Fin"
        );
        int op = 0;
        do {
            System.out.println(menu);
            try {
                op = Integer.parseInt(sc.nextLine());
                switch (op) {
                    case 1:
                        System.out.println(lista);
                        break;
                    case 2:
                        String nombre,
                                apellido,
                                mail;
                        long tlf = 0;
                        boolean tlfCorrecto = false;
                        System.out.println("Introduce Nombre");
                        nombre = sc.nextLine();
                        System.out.println("Introduce Apellido");
                        apellido = sc.nextLine();
                        do {
                            System.out.println("Introduce Telefono");
                            try {

                                tlf = Integer.parseInt(sc.nextLine());
                                tlfCorrecto = true;
                            } catch (NumberFormatException e) {
                                System.out.println("El telefono introducido no es valido.");
                            }
                        } while (!tlfCorrecto);
                        System.out.println("Introduce mail");
                        mail = sc.nextLine();

                        Contacto c = new Contacto(nombre, apellido, tlf, mail);
                        lista.insertar(c);

                        break;
                    case 3:

                        System.out.println("Busca contacto a borrar (Nombre, tlf, etc):");
                        String busqueda = sc.nextLine();
                        Lista respuesta = lista.busca(busqueda);
                        int subop = -1;
                        do {
                            System.out.println("Resultado de la busqueda, introduzca contacto a eliminar o 0 para cancelar.");

                            System.out.println(respuesta);
                            try {
                                subop = Integer.parseInt(sc.nextLine());
                               if( lista.borrar(respuesta.getContacto(subop))) {
                                   System.out.println("Contacto eliminado");
                                   subop = 0;
                               } else
                                   System.out.println("Contacto no borrado");
                            } catch (NumberFormatException e) {
                                System.out.println("Caracter no reconocido");
                            }
                        } while (subop != 0);
                        break;
                    case 4:
                        System.out.println("Introduce busqueda (tlf, nombre, etc):");
                        busqueda = sc.nextLine();
                        respuesta = lista.busca(busqueda);

                        System.out.println(respuesta);

                        break;
                    case 5:
                        break;
                    default:
                        break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Caracter introducido no válido.");
            }
        } while (op != 5);

        ListaToFichero ltf = new ListaToFichero(lista);

        ltf.toFichero(f);


    }
}
