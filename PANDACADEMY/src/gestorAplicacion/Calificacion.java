package gestorAplicacion;
import Nota.*;
import java.util.*;
public class Calificacion {

	private ArrayList<Nota> notas = new ArrayList<Nota>();
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
	public Asignatura getAsignatura() {
		return this.asignatura;
	}
	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	} 
	public float promedio() {
		float cont=0;
		for (int i=0;i<notas.size();i++) {
			cont=cont + (notas.get(i).getNota()*notas.get(i).getPorcentaje()) ;
		}
		return cont;
	}
}
