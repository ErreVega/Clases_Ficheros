package Main;

import Clases.Alumno;
import Clases.Lista;

import java.io.*;
import java.util.Scanner;

public class Main12_4 {
    public static void main(String[] args) {

        Lista l = new Lista();

        int[][] notas1 = {{1, 2, 3}, {3, 3, 3}, {4, 4, 4}, {5, 5, 5}, {6, 6, 6}, {9, 2, 3}};
        int[][] notas2 = {{7, 5, 3}, {3, 8, 3}, {1, 7, 2}, {8, 6, 5}, {7, 2, 6}, {9, 2, 3}};
        int[][] notas3 = {{3, 8, 3}, {10, 9, 8}, {4, 8, 6}, {7, 1, 2}, {3, 9, 6}, {9, 2, 3}};


        Alumno a1 = new Alumno("Jorge", "Lopez", "Madrid", notas1);
        Alumno a2 = new Alumno("Paco", "Garcia", "Barcelona", notas2);
        Alumno a3 = new Alumno();
        a3.setNotas(notas3);
        Alumno a4 = new Alumno("Paco", "Cabanillas", "Barcelona", notas2);
        Alumno a5 = new Alumno("Paco", "Barcenas", "Barcelona", notas2);


        l.insertar(a1);
        l.insertar(a2);
        l.insertar(a3);
        l.insertar(a4);
        l.insertar(a5);

        System.out.println("Introduce nombre de archivo");
        Scanner sc = new Scanner(System.in);
        String nombre_archivo = sc.nextLine();
        if (!nombre_archivo.endsWith(".txt"))
            nombre_archivo = nombre_archivo + ".txt";

        String op, subop;
        Alumno nuevo;
        try {
            do {
                int[][] notas_defecto = new int[Alumno.getAsignaturas().length][Alumno.getTrimestres()];
                System.out.println("¿Quiere introducir un nuevo alumno? [S]i/ [N]o");
                op = sc.nextLine();

                switch (op) {
                    case "S":
                    case "s":
                        System.out.println("Introduce nombre alumno");
                        String nombre = sc.nextLine();
                        System.out.println("Introduce Apellidos");
                        String apellido = sc.nextLine();
                        System.out.println("Introduce Ciudad de nacimiento");
                        String ciudad = sc.nextLine();
                        boolean introducidas = false;

                        do {
                            System.out.println("¿Quiere introducir Notas? [S]i/ [N]o");
                            subop = sc.nextLine();
                            switch (subop) {
                                case "S":
                                case "s":
                                    for (int i = 0; i < Alumno.getAsignaturas().length; i++) {
                                        System.out.println("Introduce notas de " + Alumno.getAsignaturas(i));
                                        for (int j = 0; j < Alumno.getTrimestres(); j++) {
                                            System.out.println("Introduce nota " + (j + 1));
                                            notas_defecto[i][j] = sc.nextInt();
                                            sc.nextLine();
                                        }
                                    }
                                    introducidas = true;
                                    break;
                                case "N":
                                case "n":
                                    break;
                                default:
                                    System.out.println("Caracter no reconocido");
                                    break;
                            }
                        } while (!subop.equalsIgnoreCase("n") && !introducidas);

                        nuevo = new Alumno(nombre, apellido, ciudad, notas_defecto);
                        l.insertar(nuevo);

                        break;
                    case "N":
                    case "n":
                        break;
                    default:
                        System.out.println("Caracter no reconocido");
                        break;
                }
            } while (!op.equalsIgnoreCase("n"));
        } catch (StringIndexOutOfBoundsException e) {

        }

        sc.close();

        File salida = new File(nombre_archivo);
        try {

            if (salida.exists())
                System.out.println("El archivo ya existia y se ha sobreescrito");
            else
                salida.createNewFile();
            FileOutputStream fo = new FileOutputStream(salida);
            DataOutputStream dos = new DataOutputStream(fo);
            byte[] data = l.toString().getBytes();
            for (int i = 0; i < data.length; i++)
                dos.writeByte(data[i]);
            fo.close();
            dos.close();
            System.out.println(l.toString());

        } catch (IOException e) {
            System.out.println("Error al crear el archivo.");
        }

    }

}
