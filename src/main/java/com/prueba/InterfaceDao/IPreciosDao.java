package com.prueba.InterfaceDao;

import java.util.List;

import com.prueba.modelo.Precios;
import com.prueba.modelo.Producto;

public interface IPreciosDao {

	public  boolean actualizar(Precios precio);
	public List<Precios> obtener();
	
}
