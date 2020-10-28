package gestorAplicacion;

import java.io.Serializable;
import java.util.*;

public class Estudiante extends Persona implements Serializable {
  private PlanEstudio planDeEstudio;
  private ArrayList<Semestre> semestres = new ArrayList<>();

  public void setPlanDeEstudo(PlanEstudio planDeEstudio) {
    this.planDeEstudio = planDeEstudio;
  }

  public PlanEstudio getPlanDeEstudio() {
    return planDeEstudio;
  }

  public ArrayList<Semestre> getSemestres() {
    return semestres;
  }

  public void addSemestre(Semestre semestre) {
    this.semestres.add(semestre);
  }

  public float getPAPA() {
    float total = 0;
    for (int i = 0; i < semestres.size(); i++) {
      Semestre s = semestres.get(i);
      total += s.promedioSemetre();
    }
    total /= semestres.size();
    return total;
  }

  public String getHorario() {
    String comp = "";
    Semestre ultimoSemestre = semestres.get(semestres.size() - 1);
    for (int i = 0; i < ultimoSemestre.getAsignaturas().size(); i++) {

      comp = comp + ultimoSemestre.getAsignaturas().get(i).getNombre() + "\n"
          + ultimoSemestre.getAsignaturas().get(i).mostrarHorario();
    }
    return comp;
  }
}
