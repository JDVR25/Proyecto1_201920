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
				try
				{
					if(cargaRealizada)
					{
						System.out.println("--------- \nIngrese el mes");
						int mes = Integer.parseInt(lector.next());
						if(mes > 0 && mes <= 12)
						{
							System.out.println("--------- \nIngrese el identificador de la zona de origen");
							int zonaOrigen = Integer.parseInt(lector.next());

							System.out.println("--------- \nIngrese el identificador de la zona de destino");
							int zonaDestino = Integer.parseInt(lector.next());

							Viaje elViaje = modelo.consultarViajeMes(mes, zonaOrigen, zonaDestino);
							if(elViaje != null)
							{
								System.out.println("Tiempo promedio : " + elViaje.darTiempoViaje());
								System.out.println("Desviacion estandar del tiempo promedio : " + elViaje.darTiempoViaje());
							}
							else
							{
								System.out.println("No hay informacion de los viajes que durante el mes " + mes + " que salieron de la zona " + zonaOrigen + " y llegaron a la zona "+ zonaDestino);
							}
						}
						else
						{
							System.out.println("--------- \nEl mes debe ser en numero entre 1 y 12 ");
						}
					}
					else
					{
						System.out.println("--------- \nNo se han cargado los datos");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("--------- \nDebe ingresar los datos como numeros enteros");
				}
				break;

			case 3:
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 4: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 5: 
				//TODO pendiente
				try
				{
					if(cargaRealizada)
					{
						System.out.println("--------- \nIngrese el dia");
						int dia = Integer.parseInt(lector.next());
						if(dia > 0 && dia <= 7)
						{
							System.out.println("--------- \nIngrese el identificador de la zona de origen");
							int zonaOrigen = Integer.parseInt(lector.next());

							System.out.println("--------- \nIngrese el identificador de la zona de destino");
							int zonaDestino = Integer.parseInt(lector.next());

							Viaje elViaje = modelo.consultarViajeDia(dia, zonaOrigen, zonaDestino);
							if(elViaje != null)
							{
								System.out.println("Tiempo promedio : " + elViaje.darTiempoViaje());
								System.out.println("Desviacion estandar del tiempo promedio : " + elViaje.darTiempoViaje());
							}
							else
							{
								System.out.println("No hay informacion de los viajes que durante el dia " + dia + " que salieron de la zona " + zonaOrigen + " y llegaron a la zona "+ zonaDestino);
							}
						}
						else
						{
							System.out.println("--------- \nEl dia debe ser en numero entre 1 y 7 ");
						}
					}
					else
					{
						System.out.println("--------- \nNo se han cargado los datos");
					}
				}
				catch (NumberFormatException e)
				{
					System.out.println("--------- \nDebe ingresar los datos como numeros enteros");
				}
				break;

			case 6: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 7: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 8: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 9: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
				break;

			case 10: 
				//TODO pendiente
				if(cargaRealizada)
				{

				}
				else
				{
					System.out.println("--------- \nNo se han cargado los datos");
				}
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
