package gertorAplicacion;

import java.util.ArrayList;
import Horario.*;

public class Asignatura {

    private int creditos;
    private String nombre;
    private Profesor profesor;
    private Calificacion calificaciones;
    private ArrayList<Horario> horarios = new Arraylist<>();

    //constructores
    public Asignatura(){}

    public Asignatura(int cred, String nom){
        this.creditos = cred;
        this.nombre = nom;
    }

    public Asignatura(int cred, String nom, Profesor p){
        this.creditos = cred;
        this.nombre = nom;
        this.profesor = p;
    }

    public Asignatura(int cred, String nom, Profesor p, String det){
        this.creditos = cred;
        this.nombre = nom;
        this.profesor = p;
        this.detalles = det;
    }

    public Asignatura(int cred, String nom, String det){
        this.creditos = cred;
        this.nombre = nom;
        this.detalles = det;
    }

    //metodos get y set
    public void setCreditos(int c) {
        this.creditos = c;
    }

    public int getCreditos(){
        return this.creditos;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setProfesor(Profesor p) {
        this.profesor = p;
    }

    public Profesor getProfesor() {
        return this.profesor;
    }

    public void setCalificaciones(Calificacion n) {
        this.calificaciones = n;
        n.setAsignatura(this);
    }

    public Calificacion getCalificaciones() {
        return this.calificaciones;
    }

    public void setHorario(ArrayList<Horario> h) {
        this.horarios = h;
    }

    public void addHorario(Horario h) {
        this.horarios.add(h);
    }

    public ArrayList<Horario> getHorarios() {
        return this.horarios;
    }

    public Horario getHorario(int i) {
        return this.horarios.get(i);
    }

    public void setDetalles(String text) {
        this.detalles = text;
    }

    public String getDetalles() {
        return this.detalles;
    }
 
    /*public String estadoAsignatura() {
        Calificacion n = this.getCalificaciones();
        double nota = 0;
        for(int i = 0; i < n.getNotas().size(); i++){
            //se suman todas las notas en las calificaciones, las notas tienen que estar multiplicadas por su %
        }
        if (nota >= 3.0) {
            return "Aprovada " + String.ValueOf(nota);
        } else {
            return "No aprovada " + String.valueOf(nota);
        }
    } */

    public void MostrarNotas() {
        System.out.println("Tus notas de " + this.nombre + "son: ");
        Calificacion n = this.getCalificaciones();
        for(int i = 0; n.getNotas().size(); i++){
            System.out.print(n.getNotas(i).getCalificacion + " "); //imprime una lista de todas las notas
        }
    }

    /*public double Promedio(){
        Calificacion n = this.getCalificaciones();

    }*/

    public void MostrarHorario() {
        for(int i = 0; i < this.getHorarios().size(); i++){
            System.out.println(this.getHorario(i).toString());
        }
    }

    public void borrarHorario(Horario h) {
        int horario = this.getHorarios().indexOf(h);
        if(horario >= 0){
            this.getHorarios().remove(horario);
        }
    }
}