package BaseDatos;
import gestorAplicacion.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialization{ 
	
	static File archivo = new File("");
	
	public static void serializarE(Estudiante est) {
		try {
			FileOutputStream f = new FileOutputStream("personas.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(est);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

	public static void serializarP() {
		try {
			FileOutputStream f = new FileOutputStream("profesores.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(Profesor.profesores);

			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
}
