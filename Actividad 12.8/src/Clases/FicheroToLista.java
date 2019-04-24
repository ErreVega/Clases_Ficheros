package Clases;

import java.io.*;

public class FicheroToLista {

    private File f_entrada;

    public FicheroToLista(File f_entrada) {
        this.f_entrada = f_entrada;
    }

    public void toLista(Lista lista) throws FileNotFoundException{


        FileReader fr = new FileReader(this.f_entrada);
        BufferedReader bf = new BufferedReader(fr);

        String linea,
                nombre = "",
                apellido = "",
                mail = "",
                sTelf ="";
        long tlf = 0;

        Contacto contacto;
        int cont = 0;

        try {
            while ((linea = bf.readLine()) != null) {

                if (linea.contains("Nombre")) {
                    linea = linea.replaceAll("Nombre: ", "");
                    nombre = linea.trim();
                } else if (linea.contains("Apellidos: ")) {
                    linea = linea.replaceAll("Apellidos: ", "");
                    apellido = linea.trim();
                } else if (linea.contains("Telefono: ")) {
                    linea = linea.replaceAll("Telefono: ", "");
                    sTelf = linea.trim();
                    try {
                        tlf = Integer.parseInt(sTelf);
                    } catch (NumberFormatException e) {
                    }
                } else if (linea.contains("Email: ")) {
                    linea = linea.replaceAll("Email: ", "");
                    mail = linea.trim();
                    contacto = new Contacto(nombre, apellido, tlf, mail);
                    lista.insertar(contacto);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
        }
    }
}
