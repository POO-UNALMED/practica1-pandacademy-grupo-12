package gestorAplicacion;

import java.io.Serializable;
import java.util.*;

public class Estudiante extends Persona implements Serializable {
  private String planDeEstudio;
  private int creditosR;
  private ArrayList<Semestre> semestres = new ArrayList<>();

  public void setPlanDeEstudo(String planDeEstudio) {
    this.planDeEstudio = planDeEstudio;
  }

  public String getPlanDeEstudio() {
    return planDeEstudio;
  }

  public void setCreditosR(int c) {
    creditosR = c;
  }

  public int getCreditosR() {
    return creditosR;
  }

  public ArrayList<Semestre> getSemestres() {
    return semestres;
  }

  public void addSemestre(Semestre semestre) {
    semestres.add(semestre);
    Collections.sort(semestres);
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

  public int avanceCarrera() {
    float avance = 0;
    int cap = 0;
    if (creditosR > 0) {
      for (Semestre semestre : semestres) {
        cap += semestre.creditosAprobados();
        System.out.println(cap);
      }
      avance = (float) cap/creditosR;
      System.out.println(avance);
      return Math.round(avance*100);
    }
    return (int) avance;
	}
}
