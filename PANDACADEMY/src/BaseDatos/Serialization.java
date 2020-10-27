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
	
	public static void serializar(Estudiante estudiante) {
		
		try {
			FileOutputStream f = new FileOutputStream("personas.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
				
			o.writeObject(estudiante);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
}
