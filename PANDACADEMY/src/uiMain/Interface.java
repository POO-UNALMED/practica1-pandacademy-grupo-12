package uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import gestorAplicacion.*;

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

    int comando = 0, comando1, comando2;

    // menu principal de la aplicacion
    System.out.println(" \n" + e.getNombre().toUpperCase());
    while (comando != 5) {

      System.out.println(
          "\n=====MENU PRINCIPAL=====\n[0] PERFIL\n[1] ASIGNATURAS\n[2] NOTAS\n[3] HORARIO\n[4] PROFESORES\n[5] SALIR\n");
      comando = Integer.parseInt(br.readLine());

      switch (comando) {

        case 0:
          comando1 = 0;
          comando2 = 0;
          while (comando1 != 9) { // bucle para el menu PERFIL hasta que se ingrese 9

            System.out.println(
                "\n====PERFIL==== \n [0] MOSTRAR MI PERFIL \n [1] EDITAR MI PERFIL \n [9] VOLVER AL MENU PRINCIPAL \n");
            comando1 = Integer.parseInt(br.readLine());

            switch (comando1) {
              case 0:
                System.out.println("\nNombre: " + e.getNombre() + "\n" + "Correo: " + e.getCorreo() + "\n"
                    + "Docuemto identidad: " + e.getDni() + "\n" + "Plan de estudios: " + e.getPlanDeEstudio() + "\n");
                // automaticamente regresa al menu PERFIL
                break;
              case 1:
                while (comando2 != 9) { // bucle para que se imprima el menú hasta que se ingrese 9

                  System.out
                      .println("\n===EDITAR MI PERFIL=== \n [0] EDITAR NOMBRE  \n [1] EDITAR DOCUMENTO DE IDENTIDAD \n "
                          + "[2] EDITAR CORREO \n [3] EDITAR PLAN DE ESTUDIOS \n [9] VOLVER \n");
                  comando2 = Integer.parseInt(br.readLine());

                  switch (comando2) {
                    case 0:
                      System.out.println("\nDIGITE EL NUEVO NOMBRE: ");
                      e.setNombre(br.readLine());
                      break;
                    case 1:
                      System.out.println("\nDIGITE EL NUEVO DOCUMENTO DE IDENTIDAD: ");
                      e.setDni(Integer.parseInt(br.readLine()));
                      break;
                    case 2:
                      System.out.println("\nDIGITE EL NUEVO CORREO: ");
                      e.setCorreo(br.readLine());
                      break;
                    case 3:
                      System.out.println("\nDIGITE EL NUEVO PLAN DE ESTUDIO: ");
                      e.setPlanDeEstudo(br.readLine());
                      System.out.println();
                      break;
                  }
                }
                break;
            }
          }
          break;// final del menu PERFIL

        case 1:
          comando1 = 0;
          String nombre, creditos, profesor, det;
          while (comando1 != 9) {
            System.out.println(
                "\n====ASIGNATURAS====\n[0] MIS ASIGNATURAS\n[1] EDITAR ASIGNATURAS\n[2] AGREGAR ASIGNATURA\n[3] ELIMINAR ASIGNATURA\n[9] VOLVER\n");
            comando1 = Integer.parseInt(br.readLine());

            switch (comando1) {
              case 0:
                if (e.getAsignaturas().size() > 0) {
                  for (int i = 0; i < e.getAsignaturas().size(); i++) {
                    System.out.println(
                        e.getAsignatura(i).getNombre().toUpperCase() + "   " + e.getAsignatura(i).estadoAsignatura());
                  }
                }
                else{System.out.println("\nNO TIENES ASIGNATURAS INSCRIPTAS");}
                break;

              case 1:
                // menu de editar asignatura
                break;
              case 2:

                System.out.println("\n===NUEVA ASIGNATURA===\n* obligatorios\n*NOMBRE DE LA ASIGNATURA: ");
                nombre = br.readLine();
                System.out.println("*CREDITOS: ");
                creditos = br.readLine();
                System.out.println("PROFESOR: ");
                profesor = br.readLine();
                System.out.println("DETALLES: ");
                det = br.readLine();

                if (profesor.equals("") && det.equals("")) {
                  e.addAsignatura(Integer.parseInt(creditos), nombre);
                } else if (profesor.equals("")) {
                  e.addAsignatura(Integer.parseInt(creditos), nombre, det);
                } else if (det.equals("")) {
                  e.addAsignatura(Integer.parseInt(creditos), nombre, new Profesor(profesor));
                } else {
                  e.addAsignatura(Integer.parseInt(creditos), nombre, new Profesor(profesor), det);
                }
                System.out.println("\nASIGNATURA CREADA\n");
                break;
              case 3:
                System.out.println("\n===BORRAR ASIGNATURA===\nNOMBRE DE LA ASIGNATURA: ");
                nombre = br.readLine();
                boolean chek = false;
                for (int i = 0; i < e.getAsignaturas().size(); i++) {
                  Asignatura m = e.getAsignatura(i);
                  if (m.getNombre().equalsIgnoreCase(nombre)) {
                    e.getAsignaturas().remove(i);
                    System.out.println("ASIGNATURA BORRADA");
                    chek = true;
                    break;
                  }
                }
                if (!chek) {
                  System.out.println("ESTA ASIGNATURA NO SE ENCUENTRA");
                }
                break;
            }
          }
          break;// fin menu de ASIGNATURAS
        case 2:
          break;// menu de NOTAS
        case 3:
          comando1 = 0;
          while (comando1 != 9) {
            System.out.println(
                "\n====HORARIOS====\n[0] MOSTRAR HORARIO DE CLASES\n[1] MOSTRAR HORARIO DE ASESORIAS\n[9] VOLVER\n");
            comando1 = Integer.parseInt(br.readLine());

            switch (comando1) {
              case 0:
                for (int i = 0; i < e.getAsignaturas().size(); i++) {
                  e.getAsignatura(i).mostrarHorario();
                }
                break;

              case 1:
                for (int i = 0; i < e.getAsignaturas().size(); i++) {
                  e.getAsignatura(i).getProfesor().getHorario();
                  ;
                }
            }
          }
          break;// fin del menu HORARIO
      }

    }

  }

}
