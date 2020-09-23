package com.prueba.Controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import com.prueba.Dao.ProductoDaoImplementacion;
import com.prueba.Dao.StockDaoImplementacion;
import com.prueba.Vista.VistaProducto;
import com.prueba.modelo.Producto;
import com.prueba.modelo.Stock;

public class ControladorStock {
	private VistaProducto vista= new VistaProducto();
	public ControladorStock() {
	}
	
	
	public void ActualizarStock(){
		List<Stock> listadoStock = new ArrayList<Stock>();
		StockDaoImplementacion dao= new StockDaoImplementacion();
		listadoStock=dao.obtener();
		vista.ActualizarStock(listadoStock);
		OAuthConfig config = new OAuthConfig("http://c1830079.ferozo.com", "ck_11bf7cb735d7aa2fc586a61fcdabe812ce34a0ec", "cs_4dfc94158dd9dc187251d6cec85272925fbacb79");
		WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
		
		for (Stock stock : listadoStock) {
			
			Map<String, Object> actualizar = new HashMap<String, Object>();
			int stockTemp = stock.getStockDisponible();
			
		   	
			   actualizar.put("stock_quantity" , stockTemp);
			   
			
			  
			   Map resultadoUpdate= wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), stock.getid(), actualizar);
		
			
		
		}
		
		   
	}
	
	
	

}
