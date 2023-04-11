package es.studium.mvc;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;
	
	public Controlador(Modelo modelo, Vista vista)
	{
		this.modelo = modelo;
		this.vista = vista;
		
		vista.boton0.addActionListener(this);
		vista.boton1.addActionListener(this);
		vista.boton2.addActionListener(this);
		vista.boton10.addActionListener(this);
		vista.boton3.addActionListener(this);
		vista.boton4.addActionListener(this);
		vista.boton5.addActionListener(this);
		vista.boton11.addActionListener(this);
		vista.boton6.addActionListener(this);
		vista.boton7.addActionListener(this);
		vista.boton8.addActionListener(this);
		vista.boton12.addActionListener(this);
		vista.boton9.addActionListener(this);
		vista.boton15.addActionListener(this);
		vista.boton14.addActionListener(this);
		vista.boton13.addActionListener(this);
		vista.ventana.addWindowListener(this);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		String botonPulsado = ((Button) e.getSource()).getLabel();
		if (botonPulsado.equals("C"))
		{
			vista.pantalla.setText("0");
			modelo.operador1 = 0;
			modelo.operador2 = 0;
			vista.nuevoNumeroEnPantalla = true;
		}
		else if (botonPulsado.equals("="))
		{
			modelo.operador2 = Integer.parseInt(vista.pantalla.getText());
			if (modelo.operacion != null)
			{
				if (modelo.operacion.equals("+"))
				{
					vista.pantalla.setText(modelo.suma(modelo.operador1, modelo.operador2) + "");
				}
				else if (modelo.operacion.equals("-"))
				{
					vista.pantalla.setText(modelo.resta(modelo.operador1, modelo.operador2) + "");
				}
				else if (modelo.operacion.equals("*"))
				{
					vista.pantalla.setText(modelo.multiplicacion(modelo.operador1, modelo.operador2) + "");
				}
				else if (modelo.operacion.equals("/"))
				{
					vista.pantalla.setText(modelo.division(modelo.operador1, modelo.operador2) + "");
				}
			}
			vista.nuevoNumeroEnPantalla = true;
			modelo.operacion = null;
		}
		else if (botonPulsado.equals("+") || botonPulsado.equals("-") || botonPulsado.equals("*")
				|| botonPulsado.equals("/"))
		{
			modelo.operacion = botonPulsado;
			modelo.operador1 = Integer.parseInt(vista.pantalla.getText());
			vista.nuevoNumeroEnPantalla = true;
		}
		else
		{
			if (vista.nuevoNumeroEnPantalla == true)
			{
				vista.pantalla.setText(botonPulsado);
				vista.nuevoNumeroEnPantalla = false;
			}
			else
			{
				vista.pantalla.setText(vista.pantalla.getText() + botonPulsado);
				if ((vista.pantalla.getText().length() > 1) && (vista.pantalla.getText().charAt(0) == '0'))
				{
					vista.pantalla.setText(vista.pantalla.getText().substring(1));
				}
			}
		}
	}

	public void windowClosing(WindowEvent arg0)
	{
		System.exit(0);
	}

	public void windowActivated(WindowEvent arg0){}

	public void windowClosed(WindowEvent arg0){}

	public void windowDeactivated(WindowEvent arg0){}

	public void windowDeiconified(WindowEvent arg0){}

	public void windowIconified(WindowEvent arg0){}

	public void windowOpened(WindowEvent arg0){}
}
