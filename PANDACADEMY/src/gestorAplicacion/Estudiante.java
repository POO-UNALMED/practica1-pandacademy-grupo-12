package src.gestorAplicacion;

import java.util.*;

public class Estudiante extends Persona {
  private String planDeEstudio;
  private ArrayList<Asignatura> asignaturas = new ArrayList<>();

  public void setPlanDeEstudo(String planDeEstudio) {
    this.planDeEstudio = planDeEstudio;
  }

  public String getPlanDeEstudio() {
    return planDeEstudio;
  }

  public List<Asignatura> getAsignatura() {
    return asignaturas;
  }

  public Asignatura getAsignatura(String nombre) {
    for (int i = 0; i < asignaturas.size(); i++) {
      Asignatura m = asignaturas.get(i);
      if (m.getNombre().equalsIgnoreCase(nombre)) {
        return m;
      } else {
        System.out.println("Esta asignatura no se encuentra.");
      }
    }
    return null;
  }

  public float getPAPA() {
    float total = 0;
    int totalCreditos = 0;
    for (int i = 0; i < asignaturas.size(); i++) {
      total +=
        (asignaturas.get(i).promedio()) * (asignaturas.get(i).getCreditos());
      totalCreditos += asignaturas.get(i).getCreditos();
    }
    return (total / totalCreditos);
  }

  public void addAsignatura(Asignatura asignatura) {
    this.asignaturas.add(asignatura);
  }

  public void getHorario() {
    for (int i = 0; i < asignaturas.size(); i++) {
      System.out.println(asignaturas.get(i).getNombre());
      asignaturas.get(i).mostrarHorario();
    }
  }
}
