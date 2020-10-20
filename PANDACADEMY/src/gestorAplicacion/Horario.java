package gestorAplicacion;

public class Horario {
  private String dia, horaInicio, horaFinal;

  public Horario(String d, String i, String f) {
    this.dia = d;
    this.horaFinal = f;
    this.horaInicio = i;
  }

  public String getDia() {
    return this.dia;
  }

  public String getInicio() {
    return this.horaInicio;
  }

  public String getFinal() {
    return this.horaFinal;
  }

  public int getHoras() {
    int inicio = Integer.parseInt(this.horaInicio.substring(0, 1));
    int fin = Integer.parseInt(this.horaFinal.substring(0, 1));
    return fin - inicio;
  }

  public String toString() {
    String horario = dia + "\n" + horaInicio + "\n" + horaFinal;
    return horario;
  }
}
