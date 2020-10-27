package gestorAplicacion;

import java.io.Serializable;

public abstract class Persona implements Serializable {
  protected long dni;
  protected String nombre;
  protected String correo;

  public String getCorreo() {
    return correo;
  }

  public String getNombre() {
    return nombre;
  }

  public long getDni() {
    return dni;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;    
  }

  public void setDni(long num) {
    dni = num;
  }

  public void setCorreo(String correo) {
    this.correo = correo;
  }
}
