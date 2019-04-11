package Clases;
import java.io.*;

public class Orden {

    public void ordena(File input){
        try {
            FileInputStream f = new FileInputStream(input); // se introducen los numeros en un string

            int tam = f.available();
            String sNumeros = "";
            char c;
            for (int i = 0; i < tam ; i++) {
                c = (char) f.read();
                sNumeros = sNumeros + c;
            }
            f.close();

            sNumeros = sNumeros.trim(); // se formatean el string eliminando espacios para pasarlo a un array de enteros

            while (sNumeros.contains("\r")){
               sNumeros = sNumeros.replaceAll("\r", " ");
            }
            while (sNumeros.contains("\n")){
               sNumeros = sNumeros.replaceAll("\n", " ");
            }
            while (sNumeros.contains("  ")){
                sNumeros = sNumeros.replaceAll("  ", " ");
            }

            String [] numDiv = sNumeros.split(" "); //se divide el string en un array que contiene cada numero
            int [] numeros = new int[numDiv.length];
            for (int i =  0; i < numDiv.length; i ++){
                numeros[i] = Integer.parseInt(numDiv[i].trim()); // y se pasa al array de enteros casteandolo
            }

            ordenaBurbuja(numeros); // se ordena el array utilizando un metodo

            FileWriter  fout = new FileWriter(input);
            for (int i = 0; i < numeros.length; i ++) {
                fout.write(numeros[i] + "\n"); // Y se introduce en el archivo de nuevo
            }
            fout.close();

        }catch (IOException e) {
            System.out.println("Error. Archivo no encontrado");

        }

    }
    public static void ordenaBurbuja(int[] array) {
        boolean ordenado;
        do {
            ordenado = true;
            for (int i = 0; i < array.length - 1; i++) {

                if (array[i] > array[i + 1]) {
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;

                    ordenado = false;
                }
            }
        } while (!ordenado);
    }

    public static void main(String[] args) {
        Orden o = new Orden();
        File nums = new File("numeros.txt");
        o.ordena(nums);
    }
}
