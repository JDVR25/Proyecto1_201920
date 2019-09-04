package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import model.logic.Viaje;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;

	/* Instancia de la Vista*/
	private MVCView view;

	private boolean cargaRealizada;

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
		cargaRealizada = false;
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				if(!cargaRealizada)
				{
					System.out.println("--------- \nIngrese un trimestre como un numero");
					dato = lector.next();
					modelo = new MVCModelo(); 
					modelo.cargarDatos(Integer.parseInt(dato));
					System.out.println("--------- \nSe cargaran los datos: ");
					System.out.println("Datos cargados:");
					System.out.println("Total de viajes por mes: " + modelo.darNumViajesMes());
					System.out.println("Total de viajes por dias: " + modelo.darNumViajesDia());
					System.out.println("Total de viajes por horas: " + modelo.darNumViajesHora());
					System.out.println("Zona con menor identificador: " + modelo.darZonaMenor());
					System.out.println("Zona con menor identificador: " + modelo.darZonaMayor());
				}
				else
				{
					System.out.println("--------- \nLos datos ya se cargaron");
				}
				break;

			case 2:
				//TODO pendiente
				break;

			case 3:
				//TODO pendiente
				break;
				
			case 4: 
				//TODO pendiente
				break;
				
			case 5: 
				//TODO pendiente
				break;
				
			case 6: 
				//TODO pendiente
				break;
				
			case 7: 
				//TODO pendiente
				break;
				
			case 8: 
				//TODO pendiente
				break;
				
			case 9: 
				//TODO pendiente
				break;
				
			case 10: 
				//TODO pendiente
				break;

			case 11: 
				System.out.println("--------- \n Hasta pronto !! \n---------"); 
				lector.close();
				fin = true;
				break; 

			default: 
				System.out.println("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}	
}
