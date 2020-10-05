package gestorAplicacion;
import java.util.*;
public class Nota {
	private float porcentaje;
	private float calificaciones;
	
	public Nota() {
		
	}
	
	public Nota(float porcentaje,float calificaciones) {
		this.calificaciones=calificaciones;
		this.porcentaje=porcentaje;
	}
	
	public float getPorcentaje() {
		return porcentaje;
	}
	public float setPorcentaje(double porcentaje) {
		this.porcentaje = porcentaje;
	}
	public float getNota() {
		return calificaciones;
	}
	public void setNota(float calificaciones) {
		this.calificaciones = calificaciones;
	}
	

}