package gestorAplicacion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class Semestre implements Serializable, Comparable<Semestre> {

	private String nombre;
	private static ArrayList<Profesor> profesores = new ArrayList<>();
	private ArrayList<Asignatura> asignaturas = new ArrayList<>();
	private ArrayList<Horario> horarios = new ArrayList<>();

	public Semestre(String nombre) {
		this.nombre = nombre;
	}
	public Semestre() {
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
	
	public ArrayList<Horario> getHorarios(Asignatura asg){
		ArrayList<Horario> horarios = new ArrayList<>();
		for(Horario horario : this.horarios){
			if(horario.getAsignatura()==asg){
				horarios.add(horario);
			}
		}
		return horarios;
	}

	public float promedioSemetre() {
		float p = 0;
		int c = 0;
		for (int i = 0; i < asignaturas.size(); i++) {
			Asignatura m = asignaturas.get(i);
			p = +m.promedioAsignatura() * m.getCreditos();
			c = +m.getCreditos();
		}
		try { 
			return p / c;
		}
		catch (Exception e) {
			return 0;
		}
	}
		

	public int creditosAprobados() {
		int total = 0;
		for (Asignatura asignatura : asignaturas) {
			if (asignatura.getCalificaciones().promedio() >= 3) {
				total += asignatura.getCreditos();
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

	@Override
	public int compareTo(Semestre s) {
		String a = new String(String.valueOf(this.getNombre()));
		String b = new String(String.valueOf(s.getNombre()));
		return a.compareTo(b);
	}

	public void setHorario(ArrayList<Horario> h) {
		this.horarios = h;
	}

	public void addHorario(Horario h) {
		horarios.add(h);
	}

	public ArrayList<Horario> getHorarios() {
		return this.horarios;
	}

	public Horario getHorario(int i) {
		return this.horarios.get(i);
	}
}
