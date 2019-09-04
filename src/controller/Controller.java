package controller;

import java.util.Scanner;

import model.data_structures.Queue;
import model.data_structures.Stack;
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
					System.out.println("--------- \nSe cargaran los datos: ");
					dato = lector.next();
					modelo = new MVCModelo(); 
					modelo.cargarDatos();
					System.out.println("Datos cargados");
					System.out.println("Numero de viajes cargados: " + modelo.darNumViajes());
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
