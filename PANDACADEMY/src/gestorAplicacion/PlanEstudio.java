package gestorAplicacion;
import java.io.Serializable;
import java.util.ArrayList;

import BaseDatos.*;

public class PlanEstudio implements Serializable{
	private String nombre;
	private int creditosR;
	
	public PlanEstudio (String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCreditosR() {
		return creditosR;
	}
	public void setCreditosR(int creditosR) {
		this.creditosR = creditosR;
	}
	
	public String avanceCarrera(Estudiante estudiante){
		int creditosAp=0;
		ArrayList<Semestre> s = estudiante.getSemestres();
		for (int i = 0; i < s.size(); i++) {
			creditosAp += s.get(i).creditosAprobados();
		}
		return ((creditosAp / this.creditosR)+" %");
		
	}

}
