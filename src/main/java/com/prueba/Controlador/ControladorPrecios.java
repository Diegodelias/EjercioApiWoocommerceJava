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
import com.prueba.Dao.PreciosDaoImplementacion;
import com.prueba.Vista.VistaProducto;
import com.prueba.modelo.Precios;
import com.prueba.modelo.Producto;

public class ControladorPrecios {
	private VistaProducto vista= new VistaProducto();
	
	public ControladorPrecios() {
	}
	
	public void ActualizarPrecios(){
	List<Precios> precios = new ArrayList<Precios>();
	PreciosDaoImplementacion dao= new PreciosDaoImplementacion();
	precios=dao.obtener();
	vista.ActualizarPrecios(precios);
	OAuthConfig config = new OAuthConfig("http://c1830079.ferozo.com", "ck_11bf7cb735d7aa2fc586a61fcdabe812ce34a0ec", "cs_4dfc94158dd9dc187251d6cec85272925fbacb79");
	WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
	
	for (Precios precio : precios) {
		
		Map<String, Object> actualizarprecio = new HashMap<String, Object>();
	 	int precioTemp = precio.getprecioCompraPesos();
	   	String StringprecioTemp = String.valueOf(precioTemp);
		int precioTempVenta = precio.getprecioVentaPesos();
	   	String StringprecioVentaTemp = String.valueOf(precioTempVenta);
		
	
		  
		   actualizarprecio.put("regular_price", StringprecioTemp);
		   actualizarprecio.put("sale_price", "32323");
		
		   Map resultadoUpdate= wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), precio.getid(), actualizarprecio);
	
		 
	
	
	}
	
}
	
}
