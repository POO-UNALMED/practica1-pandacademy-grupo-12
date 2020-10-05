package gestorAplicacion;

import java.util.*;

public class Profesor {
	
	private List<Horario> asesoria;
	private Asignatura asignatura;
	public String detalles;
	
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}
	
	public Asignatura getAsignatura() {
		return asignatura;
	}
	
	public Horario getHorario() {
		for(int i=0, i < asesoria.size(), i++) {
			return asesoria(i);
		}
	}
}
