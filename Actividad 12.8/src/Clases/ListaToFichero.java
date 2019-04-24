package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ListaToFichero {

    private Lista lista;

    public ListaToFichero(Lista lista) {
        this.lista = lista;
    }

    public void toFichero(File f){
        try {
            FileWriter fw = new FileWriter(f);
            BufferedWriter bw = new BufferedWriter(fw);
            String s = lista.toString();

            bw.write(s);

            bw.close();
            fw.close();
        }catch (IOException e) {

        }

    }
}
