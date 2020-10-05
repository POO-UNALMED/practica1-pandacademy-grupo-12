package gestorAplicacion;
import Asignatura.*;
import Horario.*;
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
	
	public void getHorario() {
		for(int i=0; i < asesoria.size(); i++) {
			System.out.println("Asesorias: ");
			System.out.println(asignatura.getNombre());
			System.out.println(asesoria.get(i).toString());
		}
	}
}
