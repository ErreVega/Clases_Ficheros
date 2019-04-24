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
                ciudad = "";
        String[] datos,
                sNotas;

        int[][] notas = new int[Alumno.getAsignaturas().length][Alumno.getTrimestres()];
        Alumno alumno;

        try {
            while ((linea = bf.readLine()) != null) {
                alumno = null;
                if (linea.contains("Alumno:")) {
                    linea = linea.replaceAll("Alumno:", "");
                    datos = linea.split(",");

                    nombre = datos[1].trim();
                    apellido = datos[0].trim();
                } else if (linea.contains("Ciudad nacimiento:")) {
                    ciudad = linea.replaceAll("Ciudad nacimiento:", "").trim();
                } else {
                    for (int i = 0; i < Alumno.getAsignaturas().length; i++) {
                        if (linea.contains(Alumno.getAsignaturas(i))) {
                            linea = linea.replaceAll(Alumno.getAsignaturas(i), "");
                            linea = linea.replaceAll("\t", " ");
                            linea = linea.trim();
                            sNotas = linea.split(" ");

                            for (int j = 0; j < Alumno.getTrimestres(); j++) {
                                notas[i][j] = Integer.parseInt(sNotas[j].trim());
                            }
                        }

                    }
                }
                if (linea.contains("_ _ _")) {
                    alumno = new Alumno(nombre, apellido, ciudad, notas);
                    lista.insertar(alumno);
                }
            }
            bf.close();
            fr.close();
        } catch (IOException e) {
        }


    }
}
