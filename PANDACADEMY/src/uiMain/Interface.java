package uiMain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import BaseDatos.*;
import gestorAplicacion.*;

public class Interface {

  @SuppressWarnings("unchecked")
  public static void main(String[] args) throws IOException {
    Estudiante e = Deserialization.deserializarE();
    Profesor.profesores = Deserialization.deserializarP();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("=====PANDACADEMY=====");
    if (e == null) {
      e = new Estudiante();
      System.out.println("BIENVENIDO \n POR FAVOR INGRESE SU NOMBRE: ");
      String entrada = br.readLine();
      e.setNombre(entrada);
      System.out.println("INGRESE SU DOCUMENTO DE IDENTIDAD(OPCIONAL): ");
      entrada = br.readLine();
      if (!entrada.equals("")) {
        try {
          e.setDni(Long.parseLong(entrada));
        } catch (Exception x) {
          System.out.println("ENTRADA NO VALIDA");
        }
      }
      System.out.println("INGRESE SU CORREO(OPCIONAL): ");
      e.setCorreo(br.readLine()); // el usuario ingresa sus datos personales
    }
    int comando = 0, comando1, comando2, comando3 = 0;
    String nombre, det, correo, dia, h1, h2, creditos, profesor;

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
                System.out.println("\nNOMBRE: " + e.getNombre() + "\nDOCUMENTO DE IDENTIDAD: " + e.getDni()
                    + "\nCORREO: " + e.getCorreo() + "\n" + "PLAN DE ESTUDIOS: " + e.getPlanDeEstudio() + "\n");
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                // automaticamente regresa al menu PERFIL
                break;

              case 1:
                comando2 = 0;
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
                      e.setDni(Long.parseLong(br.readLine()));
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
                } else {
                  System.out.println("\nNO TIENES ASIGNATURAS INSCRIPTAS");
                }
                System.out.println("\nPRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;

              case 1:
                comando2 = 0;
                while (comando2 != 9) {
                  System.out.println("\n===EDITAR ASIGNATURAS===\nNOMBRE DE LA ASIGNATURA QUE DESEA EDITAR: ");
                  nombre = br.readLine();
                  Asignatura asg = e.getAsignatura(nombre);
                  if (asg != null) {
                    System.out.println(
                        "\n===EDITAR ASIGNATURAS===\n[0] CREDITOS\n[1] NOMBRE\n[2] PROFESOR\n[3] CALIFICACIONES\n[4] HORARIO\n[5] DETALLES\n[9] VOLVER");
                    comando2 = Integer.parseInt(br.readLine());

                    switch (comando2) {
                      case 0:
                        System.out.println("CREDITOS:\n");
                        creditos = br.readLine();
                        asg.setCreditos(Integer.parseInt(creditos));
                        System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                        break;

                      case 1:
                        System.out.println("NOMBRE:\n");
                        nombre = br.readLine();
                        asg.setNombre(nombre);
                        System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                        break;

                      case 2:
                        System.out.println("NUEVO PROFESOR:\n");
                        profesor = br.readLine();
                        Profesor p = Profesor.Buscar(profesor);
                        if (p != null) {
                          asg.setProfesor(p);
                        } else {
                          p = new Profesor(nombre, "", "", asg);
                        }
                        System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                        break;

                      case 3:
                        comando3 = 0;
                        while (comando3 != 9) {
                          // MENU PARA MODIFICAR NOTAS, DE LA FORMA EN LA QUE SE HABIA IMPLEMENTADO LA
                          // CALCULADORA
                        }
                        break;
                      case 4:
                        // menu para modificar el horario, agregar nuevos horarios o modificar uno
                        // existente
                        break;
                      case 5:
                      System.out.println("DETALLES:\n");
                        det = br.readLine();
                        asg.setDetalles(det);
                        System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                        break;
                    }
                  } else {

                  }
                }

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

                for (int i = 0; i < e.getAsignaturas().size(); i++) {
                  if (e.getAsignatura(i).getNombre().equals(nombre)) {
                    System.out.println("\nESTA ASIGNATURA YA ESTA CREADA\n");
                    break;
                  }
                }
                if (profesor.equals("")) {
                  e.addAsignatura(new Asignatura(Integer.parseInt(creditos), nombre, det));
                } else {
                  e.addAsignatura(new Asignatura(Integer.parseInt(creditos), nombre, new Profesor(profesor), det));
                  e.getAsignatura(nombre).getProfesor().setAsignatura(e.getAsignatura(nombre));
                }

                System.out.println("\nINGRESE NUMERO DE CLASES SEMANALES:   ");
                int j = Integer.parseInt(br.readLine());
                for (int i = 0; i < j; i++) {
                  System.out.println("\n==NUEVO HORARIO==\nDIA: ");
                  dia = br.readLine();
                  System.out.println("\nHORA INICIO(HH:MM): ");
                  h1 = br.readLine();
                  System.out.println("\nHORA FINAL(HH:MM): ");
                  h2 = br.readLine();
                  boolean aux = true;
                  String comp = dia + "\n" + h1 + "\n" + h2;
                  for (int k = 0; k < e.getAsignaturas().size(); k++) {
                    if (e.getAsignatura(k).mostrarHorario().indexOf(comp) != -1) {
                      aux = false;
                    }
                  }
                  if (aux) {
                    e.getAsignatura(nombre).addHorario(new Horario(dia, h1, h2));
                    System.out.println("\nHORARIO AÑADIDO\nPRESIONE <ENTER> PARA CONTINUAR");
                    br.readLine();
                  } else {
                    System.out.println("\nHORARIO NO VALIDO\nPRESIONE <ENTER> PARA CONTINUAR");
                    br.readLine();
                    i--;
                  }
                }

                System.out.println("\nASIGNATURA CREADA\n");
                System.out.println("\nPRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
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
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;
            }
          }
          break;// fin menu de ASIGNATURAS

        case 2:// menu de NOTAS
          comando1 = 0;
          while (comando1 != 9) {
            System.out.println("\n====NOTAS====\n[0] MOSTRAR NOTAS\n[1] CALCULAR PAPA \n[2] CALCULADORA\n[9] VOLVER\n");
            comando1 = Integer.parseInt(br.readLine());
            switch (comando1) {

              case 0:
                ArrayList<Asignatura> asig = e.getAsignaturas();
                if (asig.size() != 0) {
                  for (int i = 0; i < asig.size(); i++) {
                    if (!asig.get(i).getCalificaciones().getNotas().isEmpty()) {
                      System.out.println(asig.get(i).getNombre() + ": \n" + asig.get(i).mostrarNotas() + "\n");
                    } else {
                      System.out.println("\nNO TIENES NINGUNA NOTA");
                    }
                  }
                } else {
                  System.out.println("\nNO TIENES NINGUNA NOTA");
                }
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;
              case 1:
                System.out.println("\nTU PAPA ACTUAL ES: " + e.getPAPA());
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;

              case 2:
                comando2 = 0;
                ArrayList<Nota> notas = new ArrayList<>();
                while (comando2 != 9) {

                  System.out.println("\n====CALCULADORA====\n[0] AÑADIR NOTAS\n[1] CALCULAR \n[9] VOLVER \n");
                  for (int i = 0; i < notas.size(); i++) {
                    System.out.println((i) + ". Nota: " + notas.get(i).getNota() + " Porcentaje :"
                        + Math.round(notas.get(i).getPorcentaje() * 100) + "% \n");
                  }
                  comando2 = Integer.parseInt(br.readLine());

                  switch (comando2) {
                    case 0:
                      notas.clear();
                      System.out.println("\nNUMERO DE PERIODOS O CORTES: ");
                      int p = Integer.parseInt(br.readLine());
                      for (int i = 1; i < p; i++) {
                        System.out.println("\nPORCENTAJE(%) : ");
                        float porcent = Float.parseFloat(br.readLine()) / 100;
                        System.out.println("\nNOTA: ");
                        float note = Float.parseFloat(br.readLine());
                        notas.add(new Nota(porcent, note));
                      }
                      System.out.println("\nINGRESA EL PORCENTAJE(%) DE TU ULTIMA NOTA/EXAMEN/PARCIAL: ");
                      float porcent = Float.parseFloat(br.readLine()) / 100;
                      notas.add(new Nota(porcent, 0));
                      break;
                    case 1:
                      System.out.println("\nINGRESA TU NOTA OBJETIVO: ");
                      float obj = Float.parseFloat(br.readLine());
                      float sumaP = 0;
                      for (int i = 0; i < notas.size(); i++) {
                        sumaP = sumaP + notas.get(i).getPorcentaje();
                      }
                      if (sumaP > 1) {
                        System.out.println("\nLA SUMA DE LOS PORCENTAJES NO PUEDE SER MAS DE 100% \n");
                        System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                      } else if (sumaP == 1) {
                        float fin;
                        float ponderado = 0;
                        for (int i = 0; i < notas.size() - 1; i++) {
                          ponderado = ponderado + notas.get(i).getNota() * notas.get(i).getPorcentaje();
                        }
                        if (ponderado >= obj) {
                          System.out.println("\nNECESITAS 0.0 PARA ALCANZAR TU OBJETIVO\n");
                          System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                          br.readLine();
                        } else {
                          fin = (obj - ponderado) / (notas.get(notas.size() - 1).getPorcentaje());
                          System.out.println("\nNECESITAS " + fin + " PARA ALCANZAR TU OBJETIVO\n");
                          System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                          br.readLine();
                        }

                      } else {
                        System.out.println("\nLA SUMA DE LOS PORCENTAJES NO PUEDE SER MENOS DE 100% \n");
                        System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                      }
                      break;
                  }
                }
                break;
            }
          }
          break;// fin menu de NOTAS

        case 3:
          comando1 = 0;
          while (comando1 != 9) {
            System.out.println(
                "\n====HORARIOS====\n[0] MOSTRAR HORARIO DE CLASES\n[1] MOSTRAR HORARIO DE ASESORIAS\n[9] VOLVER\n");
            comando1 = Integer.parseInt(br.readLine());

            switch (comando1) {
              case 0:
                if (!e.getAsignaturas().isEmpty()) {
                  for (int i = 0; i < e.getAsignaturas().size(); i++) {
                    try {
                      System.out.println(e.getAsignatura(i).getNombre() + "\n" + e.getAsignatura(i).mostrarHorario());
                    } catch (Exception x) {
                      System.out.println("\n" + e.getAsignatura(i).getNombre() + "NO TIENES HORARIOS ASIGNADOS\n");
                    }
                  }
                } else {
                  System.out.println("\nNO TIENES HORARIOS ASIGNADOS\n");
                }
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;

              case 1:
                if (!Profesor.profesores.isEmpty()) {
                  for (int i = 0; i < Profesor.profesores.size(); i++) {
                    try {
                      System.out.println(Profesor.profesores.get(i).getHorario());
                    } catch (Exception x) {
                      System.out.println("\nNO TIENES HORARIOS ASIGNADOS\n");
                    }
                  }
                } else {
                  System.out.println("\nNO TIENES HORARIOS ASIGNADOS\n");
                }
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;
            }
          }
          break;// fin del menu HORARIO
        case 4: // menu Profesores
          comando1 = 0;
          while (comando1 != 9) {
            System.out.println("\n====PROFESORES====\n[0] LISTA DE PROFESORES\n[1] EDITAR PROFESORES\n[9] VOLVER\n");
            comando1 = Integer.parseInt(br.readLine());

            switch (comando1) {
              case 0:
                if (!Profesor.profesores.isEmpty()) {
                  for (int i = 0; i < Profesor.profesores.size(); i++) {
                    System.out.println(Profesor.profesores.get(i).toString() + "\n");
                  }
                } else {
                  System.out.println("\nNO TIENES NINGUN PROFESOR\n");
                }
                System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                br.readLine();
                break;

              case 1:
                comando2 = 0;
                while (comando2 != 9) {
                  System.out.println(
                      "\n====EDITAR PROFESORES====\n[0] NUEVO PROFESOR\n[1] BORRAR PROFESOR\n[2] MODIFICAR PROFESOR\n[9] VOLVER\n");
                  comando2 = Integer.parseInt(br.readLine());

                  switch (comando2) {
                    case 0:
                      String asignatura2;
                      Asignatura asignatura;
                      System.out.println("\nNOMBRE: ");
                      nombre = br.readLine();
                      System.out.println("\nCORREO: ");
                      correo = br.readLine();
                      System.out.println("\nASIGANTURA: ");
                      asignatura2 = br.readLine();
                      asignatura = e.getAsignatura(asignatura2);
                      System.out.println("\nDETALLES: ");
                      det = br.readLine();
                      if (asignatura != null) {
                        new Profesor(nombre, correo, det, asignatura);
                      } else if (!asignatura2.equals("")) {
                        asignatura = new Asignatura(asignatura2);
                        new Profesor(nombre, correo, det, asignatura);
                        e.addAsignatura(asignatura);
                      } else {
                        new Profesor(nombre, correo, det, null);
                      }
                      System.out.println("\nPROFESOR CREADO\n");
                      System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                      br.readLine();
                      break;

                    case 1:
                      System.out.println("\nNOMBRE DEL PROFESOR QUE DESEA BORRAR: ");
                      nombre = br.readLine();
                      boolean aux = false;
                      for (int i = 0; i < Profesor.profesores.size(); i++) {
                        Profesor p = Profesor.profesores.get(i);
                        if (p.getNombre().equalsIgnoreCase(nombre) || p.getNombre().indexOf(nombre) >= 0) {
                          if (p.getAsignatura() != null) {
                            p.getAsignatura().setProfesor(null);
                          }
                          Profesor.profesores.remove(i);
                          System.out.println("\nPROFESOR BORRADO\n");
                          aux = true;
                          break;
                        }
                      }
                      if (!aux) {
                        System.out.println("\nESTE PROFESOR NO SE ENCUENTRA\n");
                      }
                      System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                      br.readLine();
                      break;

                    case 2:
                      System.out.println("\n===MODIFICAR PROFESOR===\nNOMBRE DEL PROFESOR QUE DESEA MODIFICAR: ");
                      nombre = br.readLine();
                      Profesor p = Profesor.Buscar(nombre);
                      if (p == null) {
                        System.out.println("\nESTE PROFESOR NO SE ENCUENTRA\n");
                        System.out.println("PRESIONE <ENTER> PARA CONTINUAR");
                        br.readLine();
                      } else {
                        comando3 = 0;
                        while (comando3 != 9) {
                          System.out.println(
                              "\n===MODIFICAR PROFESOR===\n[0] NOMBRE\n[1] CORREO\n[2] ASIGNATURA\n[3] ASESORIAS\n[4] DETALLES\n[9] VOLVER");
                          comando3 = Integer.parseInt(br.readLine());
                          switch (comando3) {
                            case 0:
                              System.out.println("\nINGRESE EL NUEVO NOMBRE: ");
                              nombre = br.readLine();
                              p.setNombre(nombre);
                              System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                              br.readLine();
                              break;

                            case 1:
                              System.out.println("\nINGRESE EL NUEVO CORREO: ");
                              correo = br.readLine();
                              p.setCorreo(correo);
                              System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                              br.readLine();
                              break;

                            case 2:
                              System.out.println("\nINGRESE LA NUEVA ASIGNATURA: ");
                              nombre = br.readLine();
                              asignatura = e.getAsignatura(nombre);
                              if (asignatura != null) {
                                p.setAsignatura(asignatura);
                              } else {
                                asignatura = new Asignatura(nombre);
                                p.setAsignatura(asignatura);
                                e.addAsignatura(asignatura);
                              }
                              System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                              br.readLine();
                              break;

                            case 3:
                              p.setAsesoria();
                              System.out.println("\nINGRESE NUMERO DE HORARIOS DE ASESORIA:   ");
                              int j = Integer.parseInt(br.readLine());
                              for (int i = 0; i < j; i++) {
                                System.out.println("\n==NUEVO HORARIO==\n");
                                System.out.println("DIA: ");
                                dia = br.readLine();
                                System.out.println("\nHORA INICIO(HH:MM): ");
                                h1 = br.readLine();
                                System.out.println("\nHORA FINAL(HH:MM): ");
                                h2 = br.readLine();
                                aux = true;
                                String comp = dia + "\n" + h1 + "\n" + h2;
                                for (int k = 0; k < e.getAsignaturas().size(); k++) {
                                  if (e.getAsignatura(k).mostrarHorario().indexOf(comp) < 0) {
                                    aux = false;
                                  }
                                }
                                if (aux) {
                                  p.setAsesoria(new Horario(dia, h1, h2));
                                  System.out.println("\nHORARIO AÑADIDO\nPRESIONE <ENTER> PARA CONTINUAR");
                                  br.readLine();
                                } else {
                                  System.out.println("\nHORARIO NO VALIDO\nPRESIONE <ENTER> PARA CONTINUAR");
                                  br.readLine();
                                }
                              }
                              System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                              br.readLine();
                              break;

                            case 4:
                              System.out.println("\nINGRESE EL NUEVO DETALLE: ");
                              det = br.readLine();
                              p.setDetalles(det);
                              System.out.println("\nCAMBIO REALIZADO\nPRESIONE <ENTER> PARA CONTINUAR");
                              br.readLine();
                              break;
                          }
                        }
                      }

                  }
                }
                break;
            }
          }
      }
    }
    Serialization.serializarE(e);
    Serialization.serializarP();
  }
}
