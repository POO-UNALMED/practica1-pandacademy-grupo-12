package BaseDatos;

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
	
	public static void main(String[] args) {
		try {
			FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath() + 
					"\\src\\archivos\\Personas.txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);
				
			for (int i=0; i<objetos.size(); i++) {
				o.writeObject(objetos.get(i));
			}
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}
	
}
