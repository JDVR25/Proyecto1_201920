package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import model.data_structures.IEstructura;
import model.data_structures.ListaSencillamenteEncadenada;
import model.data_structures.Stack;


/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IEstructura<Viaje> horas;

	private IEstructura<Viaje> dias;

	private IEstructura<Viaje> mes;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		horas = new ListaSencillamenteEncadenada<Viaje>();

		dias = new ListaSencillamenteEncadenada<Viaje>();

		mes = new ListaSencillamenteEncadenada<Viaje>();
	}

	//Requerimiento funcional 1
	public void cargarDatos(int trimestre)
	{
		CSVReader reader = null;
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-" + trimestre + "-All-HourlyAggregate.csv"));
			for(String[] param : reader)
			{
				try
				{
					Viaje nuevo = new Viaje(Integer.parseInt(param[0]), Integer.parseInt(param[1]), 
							Integer.parseInt(param[2]), Double.parseDouble(param[3]), Double.parseDouble(param[4]),
							Double.parseDouble(param[5]), Double.parseDouble(param[6]));
					horas.addLast(nuevo);
				}
				catch(NumberFormatException e)
				{

				}
			}

			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+ trimestre + "-All-MonthlyAggregate.csv"));
			for(String[] param : reader)
			{
				try
				{
					Viaje nuevo = new Viaje(Integer.parseInt(param[0]), Integer.parseInt(param[1]), 
							Integer.parseInt(param[2]), Double.parseDouble(param[3]), Double.parseDouble(param[4]),
							Double.parseDouble(param[5]), Double.parseDouble(param[6]));
					mes.addLast(nuevo);
				}
				catch(NumberFormatException e)
				{

				}
			}

			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-"+ trimestre + "-All-WeeklyAggregate.csv"));
			for(String[] param : reader)
			{
				try
				{
					Viaje nuevo = new Viaje(Integer.parseInt(param[0]), Integer.parseInt(param[1]), 
							Integer.parseInt(param[2]), Double.parseDouble(param[3]), Double.parseDouble(param[4]),
							Double.parseDouble(param[5]), Double.parseDouble(param[6]));
					dias.addLast(nuevo);
				}
				catch(NumberFormatException e)
				{

				}
			}

		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (reader != null)
			{
				try
				{
					reader.close();
				}
				catch (IOException e)
				{
					e.printStackTrace();
				}
			}

		}
	}

	public int darNumViajesMes()
	{
		return mes.size();
	}

	public int darNumViajesHora()
	{
		return horas.size();
	}

	public int darNumViajesDia()
	{
		return dias.size();
	}

	public int darZonaMenor()
	{
		//TODO pendiente
		int respuesta = 0;
		return respuesta;
	}

	public int darZonaMayor()
	{
		//TODO pendiente
		int respuesta = 0;
		return respuesta;
	}

	//TODO modificar doc requerimientos funcionales con correciones
	//En lo posible no hacer antes de que el profesor responda
	//Requerimiento funcional 2
	public Viaje consultarViajeMes(int mes, int idOrigen, int idDestino)
	{
		//TODO pendiente
		Viaje respuesta = null;
		return respuesta;
	}

	//Se puede usar cola para lucirse
	//Requerimiento funcional 3
	public IEstructura<Viaje> viajesMayorTiempoMes(int mes, int cuantos)
	{
		//TODO pendiente
		IEstructura<Viaje> respuesta = new ListaSencillamenteEncadenada<Viaje>();
		return respuesta;
	}

	//Hay una forma de hacerlo con pila para lucirse pero es mas complicada
	//Requerimiento funcional 4 no requiere metodo adicional(usa el metodo que usa req1)
	public Stack<Viaje>[] darViajesRangoZonasMes(int mes, int zona, int zonaMenor, int zonaMayor)
	{
		Stack<Viaje>[] viajes = (Stack<Viaje>[]) new Object[2];
		Stack<Viaje> zonaRango = new Stack<Viaje>();
		Stack<Viaje> rangoZona = new Stack<Viaje>();
		
		viajes[0] = zonaRango;
		viajes[1] = rangoZona;
		
		for(int i = zonaMayor; i >= zonaMenor; i--)
		{
			zonaRango.push(consultarViajeMes(mes, zona, i));
			rangoZona.push(consultarViajeMes(mes, i, zona));
		}
		
		return viajes;
	}

	//En lo posible no hacer antes de que el profesor responda
	//Requerimiento funcional 5
	public Viaje consultarViajeDia(int dia, int idOrigen, int idDestino)
	{
		//TODO pendiente
		Viaje respuesta = null;
		return respuesta;
	}
	
	//Se puede usar cola para lucirse
	//Requerimiento funcional 6
	public IEstructura<Viaje> viajesMayorTiempoDia(int dia, int cuantos)
	{
		//TODO pendiente
		IEstructura<Viaje> respuesta = new ListaSencillamenteEncadenada<Viaje>();
		return respuesta;
	}
	
	//Hay una forma de hacerlo con pila para lucirse pero es mas complicada
	//Requerimiento funcional 7 no requiere metodo adicional(usa el metodo que esta en req 5)

	//En lo posible no hacer antes de que el profesor responda
	//Requerimiento funcional 8
	public IEstructura<Viaje> viajesFranjaHoraria(int horaInicial, int horaFinal, int idOrigen, int idDestino)
	{
		//TODO pendiente
		IEstructura<Viaje> respuesta = new ListaSencillamenteEncadenada<Viaje>();
		return respuesta;
	}
	
	//Requerimiento funcional 9
	public IEstructura<Viaje> viajesMayorTiempoHora(int hora, int cuantos)
	{
		//TODO pendiente
		IEstructura<Viaje> respuesta = new ListaSencillamenteEncadenada<Viaje>();
		return respuesta;
	}
	
	//Requerimiento funcional 10
	public Viaje consultarViajeHora(int hora, int idOrigen, int idDestino)
	{
		//TODO pendiente
		Viaje respuesta = null;
		return respuesta;
	}
	
}
