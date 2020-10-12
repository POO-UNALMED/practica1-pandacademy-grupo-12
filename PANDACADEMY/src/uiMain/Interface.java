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

    // menu principal de la aplicacion
    
    System.out.println(" \n" + e.getNombre().toUpperCase()
        + "\n=====MENU PRINCIPAL===== \n [0] PERFIL \n [1] ASIGNATURAS \n [2] NOTAS \n [3] HORARIO \n [4] PROFESORES \n [5] SALIR");
    int comando = Integer.parseInt(br.readLine());
    int comando1;
    int comando2;
    
    
    switch(comando){
    
		case 0: {
			
			
				System.out.println("====PERFIL==== \n [0] MOSTRAR MI PERFIL \n [1] EDITAR MI PERFIL");
				comando1 = Integer.parseInt(br.readLine());
				
				switch(comando1){
					case 0: {
						System.out.println("Nombre: "+e.getNombre()+"\n"+ "Correo: "+e.getCorreo()+"\n" + "Docuemto identidad: "+e.getDni()+"\n"
								+"Plan de estudios: "+e.getPlanDeEstudio()+ "\n");
						System.out.println("9 PARA SALIR ");
						comando1= Integer.parseInt(br.readLine());
						break;
						
						
					}
					case 1: {
						
						boolean aux=true;
						
						while (aux) { // bucle para que se imprima el menú hasta que se ingrese 4 
						
							System.out.println("====EDITAR MI PERFIL==== \n [0] EDITAR NOMBRE  \n [1] EDITAR DOCUMENTO DE IDENTIDAD \n "
									+ "[2] EDITAR CORREO \n [3] EDITAR PLAN DE ESTUDIOS \n [4] SALIR" );
							comando2 = Integer.parseInt(br.readLine());
							
							switch(comando2) {
							
							case 0:{
								System.out.println("Digite el nuevo nombre: ");
								e.setNombre(br.readLine());
								break;
								
							}
							case 1:{
								System.out.println("Digite el nuevo documento de identidad: ");
								e.setDni( Integer.parseInt(br.readLine()));
								break;
								
							}
							case 2:{
								System.out.println("Digite el nuevo correo: ");
								e.setCorreo(br.readLine());
								break;
							}
							case 3:{
								System.out.println("Digite el nuevo plan de estudios: ");
								e.setPlanDeEstudo(br.readLine());
								break;
							}
							case 4:{
								aux=false;
								break;
							}
					
						
							}
							
						}				
						
						break;
					}
						
					case 2: {
						    break;
						
					}
					
				}
				System.out.println("se devolvio al menu principal");

				break;
		}
		
	
	}
    
  }
  
}
