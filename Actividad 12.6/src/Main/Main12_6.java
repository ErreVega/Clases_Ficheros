package Main;

import java.io.*;

public class Main12_6 {
    public static void main(String[] args) {

        File f = new File("numeros.txt");
        int num,
            suma = 0;
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;


            while (( line = br.readLine()) != null){
                try {
                    num = Integer.parseInt(line);

                } catch (NumberFormatException e){
                    num = 0;
                }
                suma = suma + num;
            }

        }catch (IOException e){
            System.out.println("Archivo no encontrado.");
        }


        System.out.println(suma);

    }
}
