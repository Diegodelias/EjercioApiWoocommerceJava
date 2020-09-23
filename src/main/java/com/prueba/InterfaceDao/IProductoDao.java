package com.prueba.InterfaceDao;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.prueba.modelo.Producto;

public interface IProductoDao {
	public boolean actualizar(Producto producto);
	public List<Producto> obtener();
	public boolean GetOrders() throws FileNotFoundException, IOException;
}
