package es.studium.mvc;

public class Modelo
{
	int operador1 = 0;
	int operador2 = 0;
	String operacion;
	
	public int suma(int operador1, int operador2)
	{
		return operador1 + operador2;
	}
	
	public int resta(int operador1, int operador2)
	{
		return operador1 - operador2;
	}
	
	public int multiplicacion(int operador1, int operador2)
	{
		return operador1 * operador2;
	}
	
	public int division(int operador1, int operador2)
	{
		return operador1 / operador2;
	}
}
