package gestorAplicacion;

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

  public String getHorario() {
    String comp = "";
    for (int i = 0; i < asignaturas.size(); i++) {
      comp = comp + asignaturas.get(i).getNombre()+"\n"+
      asignaturas.get(i).mostrarHorario();
    }
    return comp;
  }
}
