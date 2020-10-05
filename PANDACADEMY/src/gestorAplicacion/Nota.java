package gestorAplicacion;
import java.util.*;
public class Nota {
	private double porcentaje;
	private double calificaciones;
	
	public Nota() {
		
	}
	
	public Nota(double porcentaje,double calificaciones) {
		this.calificaciones=calificaciones;
		this.porcentaje=porcentaje;
	}
	
	public double getPorcentaje() {
		return porcentaje;
	}
	public void setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public double getNota() {
		return calificaciones;
	}
	public void setNota(double calificaciones) {
		this.calificaciones = calificaciones;
	}
	

}