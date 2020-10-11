package src.uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import src.gestorAplicacion.*;

public class Interface {

  public static void main(String[] args) throws IOException {
    Estudiante e = new Estudiante();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("=====PANDACADEMY=====");
    // aca podemos usar un metodo para ver si existen datos guardados para omitir lo
    // que sigue
    System.out.println("BIENVENIDO \n POR FAVOR INGRESE SU NOMBRE: ");
    String entrada = br.readLine();
    e.setNombre(entrada);
    System.out.println("INGRESE SU DOCUMENTO DE IDENTIDAD(OPCIONAL): ");
    entrada = br.readLine();
    if (!entrada.equals("")) {
      e.setDni(Long.parseLong(entrada));
    }
    System.out.println("INGRESE SU CORREO(OPCIONAL): ");
    e.setCorreo(br.readLine()); // el usuario ingresa sus datos personales

    // menu principal de la aplicacion
    System.out.println(" \n" + e.getNombre().toUpperCase()
        + "\n=====MENU PRINCIPAL===== \n [0] PERFIL \n [1] ASIGNATURAS \n [2] NOTAS \n [3] HORARIO \n [4] PROFESORES \n [5] SALIR");
    int comando = Integer.parseInt(br.readLine());
  }
}
