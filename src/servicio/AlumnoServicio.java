package servicio;

import entidad.AlumnoEntidad;
import java.util.ArrayList;
import java.util.Scanner;

public class AlumnoServicio {

    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    ArrayList<AlumnoEntidad> alumnado = new ArrayList<>();

    /**
     * Se pide al usuario nombre y apellido del alumno.
     * Se crea de manera random las notas de Lengua, Matematica y Ciencias.
     * Se retorna un alumno.
     * @return 
     */
    public AlumnoEntidad crearAlumno() {
        AlumnoEntidad alumno = new AlumnoEntidad();

        System.out.println("Ingrese el nombre del alumno");
        alumno.setNombre(leer.next());
        System.out.println("Ingrese el apellido del alumno");
        alumno.setApellido(leer.next());

        System.out.println("Las notas de Lengua, Matematica y Ciencias se cargarán automaticamente");
        int nota;

        for (int i = 0; i < 3; i++) {
            nota = (int) ((Math.random() * 10) + 1);
            alumno.getNotas().add(nota);
        }

        return alumno;
    }

    /**
     * Funcion de tipo ArrayList que crea una lista de alumnos.
     * Se comienza llamando la funcion crearAlumno(), que devuelve un alumno y se lo guarda en la lista "alumnado"(declarada al principio del codigo).
     * Se consulta si se quiere agregar otro alumno. En caso de "n" u otra tecla se deja de crear alumnos.
     * Se retorna la lista de alumnos.
     * @return 
     */
    public ArrayList<AlumnoEntidad> listaAlumnos() {
        char respuesta = 's';

        System.out.println("Vamos a crear la lista de alumnos");
        do {
            alumnado.add(crearAlumno());

            System.out.println("¿Quieres agregar otro alumno a la lista? s/n");
            respuesta = leer.next().charAt(0);

            if (String.valueOf(respuesta).equalsIgnoreCase("n")) {
                respuesta = 'n';
            } else if (String.valueOf(respuesta).equalsIgnoreCase("s")) {
                System.out.println("Ingrese los datos del siguiente alumno");
            } else {
                System.out.println("Tecla incorrecta, fin del programa");
                respuesta = 'n';
            }

        } while (!String.valueOf(respuesta).equalsIgnoreCase("n"));

        return alumnado;
    }

    /**
     * Se imprime la lista de alumnos registrados
     */
    public void mostrarLista() {
        System.out.println(" >Esta es la lista de alumnos registrados<");
        System.out.println("Nombre\tApellido\tL M C");

        for (AlumnoEntidad alumno : alumnado) {
            System.out.println(alumno.toString());
        }
        System.out.println("");
    }

    /**
     * Se pide al usuario el nombre del alumno de quien quiere saber el promedio.
     * En caso de que exista la persona en la lista se calcula el promedio y se imprime.
     * En caso de que no exista la persona se pregunta si quiere registrarlo. 
     * Si quiere hacerlo se llama a las funciones listaAlumnos() y calcularPromedio() sino se finaliza el programa
     */
    public void calcularPromedio() {
        System.out.println("¿De quien quiere saber el promedio? Ingrese el nombre");
        String nomAlumno = leer.next();

        Boolean existencia = false;
        for (AlumnoEntidad alumno : alumnado) {
            if (alumno.getNombre().equalsIgnoreCase(nomAlumno)) {
                existencia = true;

                int suma = 0;
                for (int i = 0; i < 3; i++) {
                    suma += alumno.getNotas().get(i);
                }

                int promedio = suma / 3;
                System.out.println("El promedio de " + nomAlumno + " es " + promedio);
            }
        }

        if (existencia == false) {
            System.out.println(nomAlumno + " no existe en esta lista");
            System.out.println("¿Quieres agregarlo?");
            char respuesta = leer.next().charAt(0);

            if (String.valueOf(respuesta).equalsIgnoreCase("s")) {
                listaAlumnos();
                calcularPromedio();
            } else {
                System.out.println("¡Gracias por usar nuestro sistema!");
            }
        }
    }
}
