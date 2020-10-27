package BaseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicacion.Estudiante;
import gestorAplicacion.Profesor;

public class Deserialization {
	static File archivo = new File("");

	public static Estudiante deserializarE() {
		Estudiante est;
		try {
			FileInputStream f = new FileInputStream(archivo.getAbsolutePath()+"\\PANDACADEMY\\src\\BaseDatos\\profesores.txt");
			ObjectInputStream o = new ObjectInputStream(f);

			est = (Estudiante) o.readObject();

			return est;

		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return null;
	}

	public static ArrayList<Profesor> deserializarP() {
		ArrayList<Profesor> p = new ArrayList<>();
		try {
			FileInputStream f = new FileInputStream(archivo.getAbsolutePath()+"\\PANDACADEMY\\src\\BaseDatos\\profesores.txt");
			ObjectInputStream o = new ObjectInputStream(f);

			p = (ArrayList<Profesor>) o.readObject();

			return p;

		} catch (ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return p;
	}
}
