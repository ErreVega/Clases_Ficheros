package Clases;
import java.io.*;
public class Censura {

    public void aplicaCensura(File principal, File censura ){

        try{
            String sPrin = leeArchivo(principal);
            System.out.println(sPrin);
        } catch (FileNotFoundException e){
            System.out.println("Error. Archivo no encontrado.");
        }

    }

    private static String leeArchivo(File input) throws FileNotFoundException {
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



    }



}
