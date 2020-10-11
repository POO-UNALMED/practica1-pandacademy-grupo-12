package src.uiMain;

import java.util.Scanner;
import src.gestorAplicacion.*;

public class Interface {

  public static void main(String[] args) {
    Estudiante e = new Estudiante();
    Scanner sc = new Scanner(System.in); // lector que se usara
    System.out.println("?????PANDACADEMY?????");
    // aca podemos usar un metodo para ver si existen datos guardados para omitir lo que sigue
    System.out.println("BIENVENIDO \n POR FAVOR INGRESE SU NOMBRE: ");
    e.setNombre(sc.nextLine());
    System.out.println("INGRESE SU DOCUMENTO DE IDENTIDAD(OPCIONAL): ");
    e.setDni(sc.nextLong());
    System.out.println("INGRESE SU CORREO: ");
    e.setCorreo(sc.nextLine()); //el usuario ingresa sus datos personales

      //menu principal de la aplicacion
    System.out.println(
    e.getNombre().toUpperCase() +
    "\n ?????MENU PRINCIPAL????? \n [0] PERFIL \n [1] ASIGNATURAS \n [2] NOTAS \n [3] HORARIO \n [4] PROFESORES \n [5] SALIR");
      int comando = sc.nextInt();
      while (true) {
        switch (comando) {
          case 1:
            System.out.println("????PERFIL???? \n [0] EDITAR PERFIL \n [1] MOSTRAR MI PERFIL");
            break;
        
          default:
            break;
        }
      }
    }
}
