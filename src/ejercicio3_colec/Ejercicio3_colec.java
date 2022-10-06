package ejercicio3_colec;

import servicio.AlumnoServicio;

public class Ejercicio3_colec {

    public static void main(String[] args) {
       AlumnoServicio alumnoServicio = new AlumnoServicio();
       
       alumnoServicio.listaAlumnos();
       alumnoServicio.mostrarLista();
       alumnoServicio.calcularPromedio();
    }    
}
