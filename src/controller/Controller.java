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
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
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
				System.out.println("--------- \nSe cargaran los datos: ");
				modelo = new MVCModelo(); 
				modelo.cargarDatos();
				System.out.println("Datos cargados");
				System.out.println("Numero de viajes cargados: " + modelo.darNumViajes());
				break;

			case 2:
				System.out.println("--------- \nIngrese la hora de inicio: ");
				dato = lector.next();
				try
				{
					int hora = Integer.parseInt(dato);
					if(hora >= 0 && hora < 24)
					{
						Queue<Viaje> cluster = modelo.eliminateCluster(hora);
						System.out.println("Numero de viajes: " + cluster.size());
						for(Viaje viaje: cluster)
						{
							System.out.println(viaje.darHora() + ", " + viaje.darIDOrigen() + ", " + viaje.darIdDestino() + ", " + viaje.darTiempoViaje());
						}
					}
					else
					{
						System.out.println("Hora invalido");
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Debe ingresar la hora como un numero");
				}
				break;

			case 3:
				System.out.println("--------- \nIngrese la hora de inicio: ");
				dato = lector.next();
				try
				{
					int hora = Integer.parseInt(dato);
					System.out.println("--------- \nIngrese la cantidad de datos deseados: ");
					dato = lector.next();
					int cant = Integer.parseInt(dato);
					if(hora >= 0 && hora < 24 && cant >= 0)
					{
						Stack<Viaje> cluster = modelo.darUltimosNViajes(hora, cant);
						for(Viaje viaje: cluster)
						{
							System.out.println(viaje.darHora() + ", " + viaje.darIDOrigen() + ", " + viaje.darIdDestino() + ", " + viaje.darTiempoViaje());
						}
					}
					else
					{
						System.out.println("Hora o cantidad invalida");
					}
				}
				catch(NumberFormatException e)
				{
					System.out.println("Tanto la hora como el numero de datos deben ser numeros");
				}
				break;
				
			case 4: 
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
