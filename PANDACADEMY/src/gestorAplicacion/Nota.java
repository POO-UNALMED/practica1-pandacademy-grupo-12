package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Nota implements Serializable{
  private float porcentaje;
  private float calificaciones;
  static public ArrayList notas = new ArrayList<>();

  public Nota() {}

  public Nota(float porcentaje, float calificaciones) {
    this.calificaciones = calificaciones;
    this.porcentaje = porcentaje;
    notas.add(this);
    
  }

  public float getPorcentaje() {
    return porcentaje;
  }

  public void setPorcentaje(float porcentaje) {
    this.porcentaje = porcentaje;
  }

  public float getNota() {
    return calificaciones;
  }

  public void setNota(float calificaciones) {
    this.calificaciones = calificaciones;
  }
}
