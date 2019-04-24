package Main;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;

import static java.nio.file.Files.getLastModifiedTime;

public class Main12_7 {
    public static void main(String[] args) {

        File carpeta = new File(".\\");

        String[] s = carpeta.list();
        String linea_max = "";

        File f = new File("lista_archivos.txt");


        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0 ; i < s.length; i ++) {

                fw.write(s[i] + "\n");
                if (linea_max.length() < s[i].length())
                    linea_max = s[i];
            }

            Path path = Paths.get(linea_max);
            try {
               FileTime fecha = Files.getLastModifiedTime(path);
               fw.write("El archivo con nombre mas largo es: " + linea_max + "\n");
               fw.write("siendo modificado por ultima vez en : "  + fecha.toString()+ "\n");
            }catch (IOException e) {
            }
            fw.close();
            bw.close();
        } catch (IOException e) {
        }
    }
}
