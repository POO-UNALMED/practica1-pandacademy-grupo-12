package gestorAplicacion;

import java.io.Serializable;
import java.util.*;

public class Profesor extends Persona implements Serializable {
  private ArrayList<Horario> asesoria = new ArrayList<>();
  private Asignatura asignatura;
  private String detalles;

  public Profesor(Semestre semestre) {
    semestre.profesores().add(this);
  }

  public Profesor(String nombre, String correo, String detalles, Asignatura asignatura, Semestre semestre) {
    this.nombre = nombre;
    this.correo = correo;
    this.detalles = detalles;
    this.asignatura = asignatura;
    semestre.profesores().add(this);
  }

  public Profesor(String nombre, Semestre semestre) {
    this.nombre = nombre;
    semestre.profesores().add(this);
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

  public String getHorario() {
    String comp = "Asesorias:\n" + asignatura.getNombre();
    for (int i = 0; i < asesoria.size(); i++) {
      comp = comp + asesoria.get(i).toString() + "\n";
    }
    return comp;
  }

  public static Profesor Buscar(String nombre, Semestre s) {
    for (int i = 0; i < s.profesores().size(); i++) {
      Profesor p = s.profesores().get(i);
      if (p.getNombre().equalsIgnoreCase(nombre)) {
        return p;
      }
    }
    return null;
  }

  public String toString() {
    String comp = "NOMBRE: " + this.nombre + "\n" + "CORREO: " + this.correo + "\n" + "ASIGNATURA: ";
    if (this.asignatura != null) {
      comp = comp + this.asignatura.getNombre() + "\n" + "DETALLES: " + this.detalles;
    }
    else{
      comp = comp + "\n" + "DETALLES: " + this.detalles;
    }
    return comp;
  }
}
