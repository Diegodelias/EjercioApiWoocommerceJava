package com.prueba.Vista;
import java.util.List;
import com.prueba.modelo.Producto;
public class VistaProducto {
	public void verProducto(Producto producto) {
		System.out.println("Datos del producto: "+producto);
	}
	
	public void verProductos(List<Producto> productos) {
		for (Producto producto : productos) {
			System.out.println("Datos del producto: codigo "+ producto.getCodigoProducto() + " descripion " + producto.getDescripcionProducto()
			+	" numero id " + producto.getid());	}		
	}

}
