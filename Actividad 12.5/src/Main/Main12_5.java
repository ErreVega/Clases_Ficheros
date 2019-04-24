package Main;

import Clases.Alumno;
import Clases.FicheroToLista;
import Clases.Lista;
import java.io.*;
import java.util.Scanner;

public class Main12_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lista lista = new Lista();
        System.out.println("Introduce nombre de fichero a editar:");
        String s = sc.nextLine();

        File f_entrada = new File(s);
        FicheroToLista ftl = new FicheroToLista(f_entrada);
        try {
            ftl.toLista(lista);
        } catch (
                FileNotFoundException e) {
            System.out.println("El archivo no existe.");
        }

        String menu = (
                "Opciones: \n" +
                "1. Editar Alumno.\n"+
                "2. Borrar Alumno\n"+
                "3. Fin");
        int op = -1,
            nAlumno,
            subop;
        Alumno editado;
        String param;

        do {
            System.out.println(menu);
            try {
                op = Integer.parseInt(sc.nextLine());

                switch (op){
                    case 1:
                        System.out.println("Elige alumno:\n" + lista.toStringNombre());
                        nAlumno = Integer.parseInt(sc.nextLine());
                        editado =  lista.getAlumno(nAlumno);
                        System.out.println(
                                "Opciones:\n"+
                                "1.Editar Nombre.\n"+
                                "2.Editar Apellido\n"+
                                "3.Editar Ciudad\n"+
                                "4.Fin"
                                );
                        subop = Integer.parseInt(sc.nextLine());
                        System.out.println(
                                editado+
                                "\nIntroduce parametro a editar:\n");

                        param = sc.nextLine();
                        switch (subop){
                            case 1:
                                editado.setNombre(param);
                                break;
                            case 2:
                                editado.setApellidos(param);
                                break;
                            case 3:
                                editado.setCiudad_nacimiento(param);
                                break;
                            case 4:
                                break;
                            default:
                                System.out.println("Opcion Incorrecta");
                                break;
                        }
                        break;
                    case 2:
                        System.out.println("Elige alumno:\n" + lista.toStringNombre());
                        nAlumno = Integer.parseInt(sc.nextLine());
                        editado =  lista.getAlumno(nAlumno);
                        lista.borrar(editado);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opcion no Valida");
                        break;
                }

            } catch (NumberFormatException e) {
                System.out.println("Caracter no valido.");
            }
        } while (op != 3);

        lista.ordena();

        System.out.println("Introduce nombre de archivo para guardar los cambios.");
        String nombre_archivo;

        nombre_archivo = sc.nextLine();

        if (!nombre_archivo.endsWith(".txt"))
            nombre_archivo = nombre_archivo + ".txt";

        File salida = new File(nombre_archivo);
        try {

            if (salida.exists())
                System.out.println("El archivo ya existia y se ha sobreescrito");
            else
                salida.createNewFile();
            FileOutputStream fo = new FileOutputStream(salida);
            DataOutputStream dos = new DataOutputStream(fo);
            byte[] data = lista.toString().getBytes();
            for (int i = 0; i < data.length; i++)
                dos.writeByte(data[i]);
            fo.close();
            dos.close();
            System.out.println(lista.toString());

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }
    }
}
