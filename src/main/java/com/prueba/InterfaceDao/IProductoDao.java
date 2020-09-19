package com.prueba.InterfaceDao;
import java.util.List;

import com.prueba.modelo.Producto;

public interface IProductoDao {
	public boolean actualizar(Producto producto);
	public List<Producto> obtener();
}
