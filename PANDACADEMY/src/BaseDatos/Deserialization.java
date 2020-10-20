package BaseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Deserialization {
	static File archivo = new File("");
	static ArrayList<ArrayList> objetos = new ArrayList<>();

	public static void main(String[] args) {
		try {
			FileInputStream f = new FileInputStream(new File(archivo.getAbsolutePath() + 
					"\\src\\archivos\\Personas.txt"));
			ObjectInputStream o = new ObjectInputStream(f);
				
			while(true) {
				ArrayList<Object> lista = (ArrayList) o.readObject();
				objetos.add(lista);
			}
			
			f.close();
			o.close();
		} catch(ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

}
