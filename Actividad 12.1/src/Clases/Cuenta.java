package Clases;

import java.io.*;

public class Cuenta {

    public int cuentaPalabras(File input) throws IOException {
        int result = 0;
        FileInputStream f = new FileInputStream(input);

        if (input.exists()){

            int tam = f.available();
            char c;
            String s = "";
            for (int i = 0; i < tam ; i++){
                c = (char) f.read();
                s = s + c;
            }


            while (s.contains("\r")){
                s = s.replaceAll("\r", " ");
            }
            while (s.contains("\n")){
                s = s.replaceAll("\n", " ");
            }
            while (s.contains("  ")){
                s = s.replaceAll("  ", " ");
            }
            s = s.trim();

            System.out.println(s);
            for (int i = 0; i < s.length(); i ++){
                char cr = s.charAt(i);
                if (cr == ' '){
                    result++;
                }
            }

        }

        return result + 1;
    }

    public static void main(String[] args) {
        File datos = new File("texto.txt");
        Cuenta c = new Cuenta();

        try {
            System.out.println(c.cuentaPalabras(datos));
        } catch (IOException e) {
            System.out.println("Error. Archivo no encontrado.");
        }
    }



}
