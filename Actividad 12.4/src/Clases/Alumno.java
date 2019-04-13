package Clases;

import java.util.Arrays;


public class Alumno {


    private static String [] asignaturas = {
            "Programacion",
            "Bases de Datos",
            "Lenguajes de Marcas",
            "Formacion y orientacion laboral",
            "Sistemas Informaticos",
            "Entornos de Desarrollo"

    };
    private static int trimestres = 3;

    private String nombre;
    private String apellidos;
    private String ciudad_nacimiento;
    private int [][] notas;

    public Alumno(String nombre, String apellidos, String ciudad_nacimiento, int[][] notas) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad_nacimiento = ciudad_nacimiento;
        this.notas = notas;
    }

    public Alumno() {
        this.nombre = "John";
        this.apellidos = "Doe";
        this.ciudad_nacimiento = "Desc";
        this.notas = new int[asignaturas.length] [Alumno.trimestres];

    }

    public Alumno(String nombre, String apellidos, String ciudad_nacimiento) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.ciudad_nacimiento = ciudad_nacimiento;
        this.notas = new int[asignaturas.length] [Alumno.trimestres];
    }

    public static String[] getAsignaturas() {
        return asignaturas;
    }

    public static String getAsignaturas(int i){
        return asignaturas[i];
    }

    public static void setAsignaturas(String[] asignaturas) {
        Alumno.asignaturas = asignaturas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCiudad_nacimiento() {
        return ciudad_nacimiento;
    }

    public void setCiudad_nacimiento(String ciudad_nacimiento) {
        this.ciudad_nacimiento = ciudad_nacimiento;
    }

    public int[][] getNotas() {
        return notas;
    }

    public void setNotas(int[][] notas) {
        this.notas = notas;
    }

    public static int getTrimestres() {
        return trimestres;
    }

    @Override
    public String toString() {
        String r = "Alumno: "+ apellidos + ", " + nombre +
                "\nCiudad nacimiento: " + ciudad_nacimiento +
                "\nNotas:\n";
        for (int i = 0; i < asignaturas.length; i++) {
            r = r + asignaturas[i] + "\t";
            for (int j = 0 ; j < this.notas[i].length; j ++){
                r = r + notas[i][j] + "\t";
            }
            r = r + "\n";
        }
        return r;
    }
    public String toStringNombreApe() {
        String r = "Alumno: "+ apellidos + ", " + nombre;

        return r;
    }
}
