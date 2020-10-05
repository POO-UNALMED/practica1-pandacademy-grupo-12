package gestorAplicacion;

import java.util.*;

public class Estudiante extends Persona {
	
	private String planDeEstudio;
	private List<Asignatura> asignaturas;
	private List<Horario> horario;
	
	public void setPlanDeEstudo(string planDeEstudio) {
		this.planDeEstudio = planDeEstudio;
	}
	public String getPlanDeEstudio() {
		return planDeEstudio;
	}
	
	public Asignatura getAsignatura() {
		
	}
	
	/*public float getPAPA() {
		float total = 0;
		int totalCreditos = 0;
		for(int i = 0; i < asignaturas.size(); i++) {
			total += (asignaturas.get(i).promedio()) * (asignaturas.get(i).getCreditos());
			totalCreditos += asignaturas.get(i).getCreditos()
		}
		return(total/totalCreditos);
	}*/
	
	public void addAsignatura(Asignatura asignatura) {
		this.asignatura.add(asignatura)
	}
	
	public Horario getHorario() {
		for(int i = 0; i < asignaturas.size(); i++) {
			System.out.println(asignaturas.get(i).getNombre());
			asignaturas.get(i).mostrarHorario();
		}
	}
}
