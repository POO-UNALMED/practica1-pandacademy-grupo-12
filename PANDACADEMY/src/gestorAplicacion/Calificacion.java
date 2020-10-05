package gestorAplicacion;
import java.util.*;
public class Calificacion {
	private Estudiante estudiante;
	public static List<Nota> Nota = new ArrayList<Nota>();
	private Asignatura asignatura;
	
	public Calificacion() {
		
	}
	
	public Calificacion( Estudiante estudiante, Asignatuara asignatura) {
		this.estudiante = estudiante;
		this.asignatura = asignatura;
	}
	public Nota agregarNota(Nota nota) {
		Nota.add(nota);
	}
	public Estudiante getEstudiante() {
		return this.estudiante;
	}
	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}
	public Asignatura getAsignatura() {
		return this.asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	} 
	public static double promedio() {
		double cont=0;
		for (int i=0;i<Nota.size();i++) {
			cont=cont + (Nota.get(i).getNota()*Nota.get(i).getPorcentaje()) ;
		}
		return cont;
	}
}
