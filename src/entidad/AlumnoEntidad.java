package entidad;

import java.util.ArrayList;

public class AlumnoEntidad {

    private String nombre, apellido;
    private ArrayList<Integer> notas = new ArrayList<>();

    public AlumnoEntidad() {
    }

    public AlumnoEntidad(String nombre, String apellido, ArrayList<Integer> notas) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.notas = notas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public ArrayList<Integer> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Integer> notas) {
        this.notas = notas;
    }

    @Override
    public String toString() {
        return nombre + "\t" + apellido + "\t" + notas;
    }
    
}
