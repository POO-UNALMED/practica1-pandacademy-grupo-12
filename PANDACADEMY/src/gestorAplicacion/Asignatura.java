package gestorAplicacion;

import java.util.ArrayList;


public class Asignatura {
  private int creditos;
  private String nombre;
  private Profesor profesor;
  private Calificacion calificaciones;
  private ArrayList<Horario> horarios = new ArrayList<>();
  private String detalles;

  //constructores
  public Asignatura() {}

  public Asignatura(int creditos, String nombrebre) {
    this.creditos = creditos;
    this.nombre = nombrebre;
  }

  public Asignatura(int creditos, String nombre, Profesor p) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.profesor = p;
  }

  public Asignatura(int creditos, String nombre, Profesor p, String det) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.profesor = p;
    this.detalles = det;
  }

  public Asignatura(int creditos, String nombre, String det) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.detalles = det;
  }

  //metodos get y set
  public void setCreditos(int c) {
    this.creditos = c;
  }

  public int getCreditos() {
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

  public String estadoAsignatura() {
    if (calificaciones!=null) {
      float nota = calificaciones.promedio();
      if (nota >= 3.0) {
        return "Aprobada " + String.valueOf(nota);
      } else {
        return "No aprobada " + String.valueOf(nota);
      } 
    }
    return "No aprobada 0.0";
  }

  public void mostrarNotas() {
    System.out.println("Tus notas de " + this.nombre + "son: ");
    ArrayList<Nota> n = this.getCalificaciones().getNotas();
    for (int i = 0; i < n.size(); i++) {
      System.out.print(n.get(i).getNota() + " "); //imprime una lista de todas las notas
    }
  }

  public float promedioAsignatura() {
    Calificacion n = this.getCalificaciones();
    return n.promedio();
  }

  public void mostrarHorario() {
    for (int i = 0; i < this.getHorarios().size(); i++) {
      System.out.println(this.getHorario(i).toString());
    }
  }

  public void borrarHorario(Horario h) {
    int horario = this.getHorarios().indexOf(h);
    if (horario >= 0) {
      this.getHorarios().remove(horario);
    }
  }
}
