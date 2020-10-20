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
	public static ArrayList<ArrayList> objetos = new ArrayList<>();

	public static void deserializar() {
		try {
			FileInputStream f = new FileInputStream("personas.txt");
			ObjectInputStream o = new ObjectInputStream(f);
				
			while(true) {
				ArrayList<Object> lista = (ArrayList) o.readObject();
				System.out.println(lista);
				objetos.add(lista);
			}
			
		} catch(ClassNotFoundException e) {
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
	}

}
