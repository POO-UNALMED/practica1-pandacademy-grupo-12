package gestorAplicacion;
import BaseDatos.*;

public class PlanEstudio {
	private String nombre;
	private int creditosR;
	
	PlanEstudio (String nombre, int creditos){
		this.nombre=nombre;
		this.creditosR=creditos;
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
	
	public String avanceCarrera(){
				
		
	}

}
