package gestorAplicacion;

import java.io.Serializable;
import java.util.*;

public class Calificacion implements Serializable{
  private ArrayList<Nota> notas = new ArrayList<Nota>();

  public Calificacion() {}

  public void agregarNota(Nota nota) {
    this.notas.add(nota);
  }

  public ArrayList<Nota> getNotas() {
    return notas;
  }

  public float promedio() {
    float cont = 0;
    for (int i = 0; i < notas.size(); i++) {
      cont = cont + (notas.get(i).getNota() * notas.get(i).getPorcentaje());
    }
    return cont;
  }
}
