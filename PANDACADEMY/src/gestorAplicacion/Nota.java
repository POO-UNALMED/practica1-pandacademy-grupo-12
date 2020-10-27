package gestorAplicacion;

import java.io.Serializable;

public class Nota implements Serializable{
  private float porcentaje;
  private float calificaciones;

  public Nota() {}

  public Nota(float porcentaje, float calificaciones) {
    this.calificaciones = calificaciones;
    this.porcentaje = porcentaje;
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
