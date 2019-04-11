package Clases;

import java.io.*;

public class Censura {

    public void aplicaCensura(File principal, File censura) {

        try {
            String sPrin = leeArchivo(principal);
            try {
                String sCen = leeArchivo(censura);
                while (sCen.contains("\r") || sCen.contains("\n")) { // mientras se encuentren saltos de linea o retornos
                    sCen = sCen.replaceAll("\r", " "); // se sustituyen por un espacio
                    sCen = sCen.replaceAll("\n", " ");
                }
                while (sCen.contains("  ")) { // mientras el string tenga 2 espacios seguidos
                    sCen = sCen.replaceAll("  ", " "); // se sustituyen por 1 solo
                }
                String [] palabrasCensura = sCen.split(" "); // se almacena cada palabra del archivo en un array.


                for (int i = 0 ; i < palabrasCensura.length; i = i + 2){    // el bucle itera solamente por las palabras pares, ya que
                                                                            // son las que se buscan sustituir
                    if (sPrin.contains(palabrasCensura[i]))               // si el string contiene dicha palabra iterada
                        sPrin = sPrin.replaceAll(palabrasCensura[i], palabrasCensura[i + 1]); // se sustituyen todas sus coincidencias con la
                                                                                        //palabra siguiente del array.
                }

                String nombre = principal.getName(); // conseguimos el nombre del archivo original
                String formato = nombre.substring( nombre.lastIndexOf(".")); // separamos su formato
                nombre = nombre.substring(0, nombre.lastIndexOf("."));    //conseguimos solamente el nombre
                nombre = nombre + "_censurado" +formato; //añadimos un subtitulo al nuevo archivo

                File archivoFinal = new File(nombre); // Se genera el archivo con el nombre asignado
                try {
                    FileWriter f = new FileWriter(archivoFinal); // generamos un flujo para escribir en el archivo
                    f.write(sPrin); // escribimos el string modificado con la censura
                    f.close();
                } catch (IOException e){
                    System.out.println("Error al crear el archivo");
                }

            } catch (IOException e) {
                System.out.println("Error. Archivo censura no encontrado");
            }
        } catch (IOException e) {
            System.out.println("Error. Archivo principal no encontrado.");
        }
    }

    private static String leeArchivo(File input) throws IOException {
        try {
            FileInputStream f = new FileInputStream(input);

            char c;
            int tam = f.available();
            String resultado = "";
            for (int i = 0; i < tam; i++) {
                c = (char) f.read();
                resultado = resultado + c;
            }
            f.close();
            return resultado;
        }catch (FileNotFoundException e){
            FileNotFoundException ex = new FileNotFoundException();
            throw ex;
        }
    }

    public static void main(String[] args) {

        File principal = new File("texto.txt");
        File censura = new File ("censura.txt");
        Censura c = new Censura();
        c.aplicaCensura(principal, censura);
    }
}
