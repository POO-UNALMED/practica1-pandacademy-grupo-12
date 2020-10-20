package gestorAplicacion;

import java.io.Serializable;
import java.util.*;

public class Estudiante extends Persona implements Serializable{
  private String planDeEstudio;
  private ArrayList<Asignatura> asignaturas = new ArrayList<>();

  public void setPlanDeEstudo(String planDeEstudio) {
    this.planDeEstudio = planDeEstudio;
  }

  public String getPlanDeEstudio() {
    return planDeEstudio;
  }

  public ArrayList<Asignatura> getAsignaturas() {
    return asignaturas;
  }

  public Asignatura getAsignatura(String nombre) {
    for (int i = 0; i < asignaturas.size(); i++) {
      Asignatura m = asignaturas.get(i);
      if (m.getNombre().equalsIgnoreCase(nombre)) {
        return m;
      }
    }
    return null;
  }

  public Asignatura getAsignatura(int index) {
    return asignaturas.get(index);
  }

  public float getPAPA() {
    float total = 0;
    int totalCreditos = 0;
    for (int i = 0; i < asignaturas.size(); i++) {
      total += (asignaturas.get(i).promedioAsignatura()) * (asignaturas.get(i).getCreditos());
      totalCreditos += asignaturas.get(i).getCreditos();
    }
    return (total / totalCreditos);
  }

  public void addAsignatura(Asignatura asignatura) {
    this.asignaturas.add(asignatura);
  }

  public void addAsignatura(int creditos, String nombre) {
    this.asignaturas.add(new Asignatura(creditos, nombre));
  }

  public void addAsignatura(int creditos, String nombre, Profesor p) {
    this.asignaturas.add(new Asignatura(creditos, nombre, p));
  }

  public void addAsignatura(int creditos, String nombrem, Profesor p, String det) {
    this.asignaturas.add(new Asignatura(creditos, nombre, p, det));
  }

  public void addAsignatura(int creditos, String nombre, String det) {
    this.asignaturas.add(new Asignatura(creditos, nombre, det));
  }

  public void getHorario() {
    for (int i = 0; i < asignaturas.size(); i++) {
      System.out.println(asignaturas.get(i).getNombre());
      asignaturas.get(i).mostrarHorario();
    }
  }
}
