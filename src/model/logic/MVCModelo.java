package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import com.opencsv.CSVReader;
import model.data_structures.IEstructura;
import model.data_structures.Queue;
import model.data_structures.Stack;

/**
 * Definicion del modelo del mundo
 *
 */
public class MVCModelo {
	/**
	 * Atributos del modelo del mundo
	 */
	private IEstructura<Viaje> pila;

	private IEstructura<Viaje> fila;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public MVCModelo()
	{
		pila = new Stack<Viaje>();

		fila = new Queue<Viaje>();
	}

	public void cargarDatos()
	{
		CSVReader reader = null;
		try 
		{
			reader = new CSVReader(new FileReader("./data/bogota-cadastral-2018-1-All-HourlyAggregate"));
			for(String[] param : reader)
			{
				try
				{
					Viaje nuevo = new Viaje(Integer.parseInt(param[0]), Integer.parseInt(param[1]), 
							Integer.parseInt(param[2]), Double.parseDouble(param[3]), Double.parseDouble(param[4]),
							Double.parseDouble(param[5]), Double.parseDouble(param[6]));
					((Stack<Viaje>) pila).push(nuevo);
					((Queue<Viaje>) fila).enqueue(nuevo);
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

	public int darNumViajes()
	{
		return pila.size();
	}

	public Stack<Viaje> darUltimosNViajes(int hour, int howManyYouWant)
	{
		Stack<Viaje> stack1 = new Stack<Viaje>(); 
		int i = 0;
		while (i < howManyYouWant && !pila.isEmpty() )
		{
			Viaje temp = ((Stack<Viaje>) pila).pop(); 
			if (temp.darHora() == hour)
			{
				stack1.push(temp);
				i++; 
			}
		}
		return stack1; 
	}

	public Queue<Viaje> eliminateCluster(int hour)
	{
		Queue<Viaje> fila1 = new Queue<Viaje>(); 
		Queue<Viaje> fila2 = new Queue<Viaje>(); 
		for(int i = 0; i < fila.size(); i++ )
		{
			Viaje temp = ((Queue<Viaje>) fila).dequeue();
			if (temp.darHora() == hour && fila2.isEmpty())
			{
				fila2.enqueue(temp);
			}
			else if (fila2.getFirst().darHora() < temp.darHora())
			{
				fila2.enqueue(temp);
			}
			else
			{
				if(fila2.size() > fila1.size())
				{
					fila1 = fila2; 
				}

				fila2 = new Queue<Viaje>(); 
			}
		}

		if(fila2.size() > fila1.size())
		{
			fila1 = fila2; 
		}

		return fila1; 
	}
}
