package src.gestorAplicacion;

import java.util.*;

public class Profesor extends Persona {
  private List<Horario> asesoria;
  private Asignatura asignatura;
  public String detalles;

  public void setAsignatura(Asignatura asignatura) {
    this.asignatura = asignatura;
  }

  public Asignatura getAsignatura() {
    return asignatura;
  }

  public void getHorario() {
    System.out.println("Asesorias: ");
    System.out.println(asignatura.getNombre());
    for (int i = 0; i < asesoria.size(); i++) {
      System.out.println(asesoria.get(i).toString());
    }
  }
}
