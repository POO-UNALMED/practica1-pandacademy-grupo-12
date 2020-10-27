package BaseDatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicacion.Estudiante;

public class Deserialization {

	public static Estudiante deserializar() {
		Estudiante estudiante = null;
		try {
			FileInputStream f = new FileInputStream("personas.txt");
			ObjectInputStream o = new ObjectInputStream(f);
				
			estudiante = (Estudiante) o.readObject();
			
			
			
		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return estudiante;
	}

}
