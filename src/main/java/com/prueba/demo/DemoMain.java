package com.prueba.demo;


import java.io.FileNotFoundException;
import java.io.IOException;

import com.prueba.Controlador.ControladorPrecios;
import com.prueba.Controlador.ControladorProducto;
import com.prueba.Controlador.ControladorStock;

public class DemoMain {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		ControladorProducto controlador = new ControladorProducto();
		ControladorPrecios controladorp = new ControladorPrecios();
		ControladorStock  controladorStock = new ControladorStock(); 
		
		controlador. ActualizarProductos();
		controlador.GetOrders();
		controladorp.ActualizarPrecios();
		controladorStock.ActualizarStock();
		
	
	}

}
