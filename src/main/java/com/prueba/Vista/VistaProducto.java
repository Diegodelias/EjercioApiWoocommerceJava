package com.prueba.Vista;
import java.util.List;

import com.prueba.modelo.Precios;
import com.prueba.modelo.Producto;
import com.prueba.modelo.Stock;
public class VistaProducto {
	public void verProducto(Producto producto) {
		System.out.println("Datos del producto: "+producto);
	}
	
	public void ActualizarProductos(List<Producto> productos) {
		for (Producto producto : productos) {
			System.out.println("Datos del producto Actualizados: codigo "+ producto.getCodigoProducto() + " descripion " + producto.getDescripcionProducto()
			+	" numero id " + producto.getid());	}		
	}

	
	public void ExcelCreado(boolean respuesta) {
		
		if (respuesta) {
			
			System.out.println("Archivo ReporteOrdenes.xlsx  creado exitosamente en ubicación C:\\reportes\\");
		}
		
		
	}
	
	
	public void ActualizarPrecios(List<Precios> precios) {
		for (Precios precio : precios) {
			System.out.println("Precios Actualizados: codigo "+ precio.getCodigoProducto() + " precio de venta pesos " + precio.getprecioVentaPesos()
			+	" precio de compra " + precio.getprecioCompraPesos() + " id " +  precio.getid());	}		
	}

	
	
	
	public void ActualizarStock(List<Stock> listastock) {
		for (Stock stock : listastock) {
			System.out.println("Stock Actualizados: codigo "+ stock.getCodigoProducto() + " stock " + stock.getStockDisponible());	
			}		
	}

	
}
