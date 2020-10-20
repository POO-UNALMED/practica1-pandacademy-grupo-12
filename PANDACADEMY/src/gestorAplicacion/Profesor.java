package gestorAplicacion;

import java.util.*;

public class Profesor extends Persona {
  public static ArrayList<Profesor> profesores = new ArrayList<>();
  private ArrayList<Horario> asesoria = new ArrayList<>();
  private Asignatura asignatura;
  private String detalles;

  public Profesor() {
    profesores.add(this);
  }

  public Profesor(String nombre, String correo, String detalles, Asignatura asignatura) {
    this.nombre = nombre;
    this.correo = correo;
    this.detalles = detalles;
    this.asignatura = asignatura;
    profesores.add(this);
  }

  public Profesor(String nombre) {
    this.nombre = nombre;
    profesores.add(this);
  }

  public void setAsignatura(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public Asignatura getAsignatura() {
    return asignatura;
  }

  public void setDetalles(String det) {
    detalles = det;
  }

  public String getDetalles() {
    return detalles;
  }

  public void setAsesoria() {
    asesoria.clear();
  }

  public void setAsesoria(Horario asesoria) {
    this.asesoria.add(asesoria);
  }

  public void getHorario() {
    System.out.println("Asesorias: ");
    System.out.println(asignatura.getNombre());
    for (int i = 0; i < asesoria.size(); i++) {
      System.out.println(asesoria.get(i).toString());
    }
  }

  public static Profesor Buscar(String nombre) {
    for (int i = 0; i < profesores.size(); i++) {
      Profesor p = profesores.get(i);
      if (p.getNombre().equalsIgnoreCase(nombre)) {
        return p;
      }
    }
    return null;
  }

  public String toString() {
    String comp = "NOMBRE: " + this.getNombre() + "\n" + "CORREO: " + this.getCorreo() + "\n" + "ASIGNATURA: "
        + this.getAsignatura().getNombre() + "\n" + "DETALLES: " + this.getDetalles();
    return comp;
  }
}
