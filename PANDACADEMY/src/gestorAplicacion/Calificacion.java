package gestorAplicacion;

import java.util.*;

public class Calificacion {
  private ArrayList<Nota> notas = new ArrayList<Nota>();
  private Asignatura asignatura;

  public Calificacion() {}

  public Calificacion(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public void agregarNota(Nota nota) {
    this.notas.add(nota);
  }

  public ArrayList<Nota> getNotas() {
    return notas;
  }

  public Asignatura getAsignatura() {
    return this.asignatura;
  }

  public void setAsignatura(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public float promedio() {
    float cont = 0;
    for (int i = 0; i < notas.size(); i++) {
      cont = cont + (notas.get(i).getNota() * notas.get(i).getPorcentaje());
    }
    return cont;
  }
}
