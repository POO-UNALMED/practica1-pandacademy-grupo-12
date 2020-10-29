package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Asignatura implements Serializable, Calificacion {
  public static ArrayList<Asignatura> asignaturas = new ArrayList<>();
  private int creditos;
  private String nombre;
  private Profesor profesor;
  private ArrayList<Nota> notas=new ArrayList<Nota>();
  private String detalles;

  // constructores
  public Asignatura() {
  }

  public Asignatura(int creditos, String nombre, Profesor p, String det) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.profesor = p;
    this.detalles = det;
  }

  public Asignatura(int creditos, String nombre, String det) {
    this.creditos = creditos;
    this.nombre = nombre;
    this.detalles = det;
  }

  // metodos get y set
  public void setCreditos(int c) {
    this.creditos = c;
  }

  public int getCreditos() {
    return this.creditos;
  }

  public void setNombre(String nom) {
    this.nombre = nom;
  }

  public String getNombre() {
    return this.nombre;
  }

  public void setProfesor(Profesor p) {
    this.profesor = p;
  }

  public Profesor getProfesor() {
    return this.profesor;
  }


  public void setDetalles(String text) {
    this.detalles = text;
  }

  public String getDetalles() {
    return this.detalles;
  }

  public String estadoAsignatura() {
    if (calificaciones != null) {
      float nota = calificaciones.promedio();
      if (nota >= 3.0) {
        return "Aprobada " + String.valueOf(nota);
      } else {
        return "No aprobada " + String.valueOf(nota);
      }
    }
    return "No aprobada 0.0";
  }

  public String mostrarNotas() {
    String comp = "Tus notas de " + this.nombre + " son:\n";
    ArrayList<Nota> n = this.getCalificaciones().getNotas();
    for (int i = 0; i < n.size(); i++) {
      comp = comp + n.get(i).getNota() + " "; // imprime una lista de todas las notas
    }
    return comp;
  }

  public float promedioAsignatura() {
    Calificacion n = this.getCalificaciones();
    return n.promedio();
  }

@Override
public void agregarNota(Nota nota) {
	// TODO Auto-generated method stub
	
}

@Override
public ArrayList<Nota> getNotas() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public float promedio() {
	float cont = 0;
	for (int i = 0; i < notas.size(); i++) {
	  cont = cont + (notas.get(i).getNota() * notas.get(i).getPorcentaje());
	}
	return cont;

	}
}
