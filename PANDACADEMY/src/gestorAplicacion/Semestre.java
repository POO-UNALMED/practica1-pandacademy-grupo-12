package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;

public class Semestre implements Serializable {

	private static ArrayList<Profesor> profesores = new ArrayList<>();
	private String nombre;
	private ArrayList<Asignatura> asignaturas = new ArrayList<>();

	public Semestre(String nombre){
		this.nombre = nombre;
	}
	public Semestre(){
	}

	public ArrayList<Profesor> profesores() {
		return profesores;	
	}

	public void setprofesores(ArrayList<Profesor> p) {
		profesores = p;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float promedioSemetre() {
		float p = 0;
		int c = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			Asignatura m = asignaturas.get(i);
			p =+ m.promedioAsignatura() * m.getCreditos();
			c =+ m.getCreditos();
		}
		return p/c;
	}

	public int creditosAprobados() {
		int total = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			Asignatura m = asignaturas.get(i);
			if (m.estadoAsignatura().indexOf("Aprobada") == 0) {
				total = total + m.getCreditos();
			}
		}
		return total;

	}

	public int totalCreditos() {
		int total = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			total = total + asignaturas.get(i).getCreditos();
		}
		return total;
	}

	public void addAsignatura(Asignatura asignatura) {
		this.asignaturas.add(asignatura);
	}

	public void removeAsignatura(Asignatura asignatura) {
		this.asignaturas.remove(asignatura);
	}

	public Asignatura getAsignatura(int index) {
		return asignaturas.get(index);
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public Asignatura getAsignatura(String nombre) {
		for (int i = 0; i < asignaturas.size(); i++) {
			Asignatura m = asignaturas.get(i);
			if (m.getNombre().equalsIgnoreCase(nombre)) {
				return m;
			}
		}
		return null;
	}

}
