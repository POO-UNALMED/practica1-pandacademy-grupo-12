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
	static ArrayList<ArrayList> objetos = new ArrayList<>();
	
	public static void serializar() {
		objetos.add(Profesor.profesores);
		objetos.add(Nota.notas);
		
		try {
			FileOutputStream f = new FileOutputStream("personas.txt");
			ObjectOutputStream o = new ObjectOutputStream(f);
				
			for (int i=0; i<objetos.size(); i++) {
				System.out.println(objetos.get(i));
				o.writeObject(objetos.get(i));
			}
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
}
