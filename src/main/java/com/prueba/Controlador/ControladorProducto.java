package com.prueba.Controlador;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.prueba.Vista.VistaProducto;
import com.prueba.modelo.Producto;
import com.prueba.InterfaceDao.IProductoDao;
import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import com.prueba.Dao.ProductoDaoImplementacion;;


public class ControladorProducto {
	
private VistaProducto vista= new VistaProducto();
	
	public ControladorProducto() {
	}
	

	
	//llama al DAO para obtener todos los clientes y luego los muestra en la vista
	public void verProductos(){
		List<Producto> productos = new ArrayList<Producto>();
		ProductoDaoImplementacion dao= new ProductoDaoImplementacion();
		productos=dao.obtener();
		vista.verProductos(productos);
		OAuthConfig config = new OAuthConfig("http://c1830079.ferozo.com", "ck_11bf7cb735d7aa2fc586a61fcdabe812ce34a0ec", "cs_4dfc94158dd9dc187251d6cec85272925fbacb79");
		WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
		
		for (Producto producto : productos) {
			
			Map<String, Object> actualizar = new HashMap<String, Object>();
			   actualizar.put("name", producto.getDescripcionProducto());
			   actualizar.put("sku", producto.getCodigoProducto());
			   Map resultadoUpdate= wooCommerce.update(EndpointBaseType.PRODUCTS.getValue(), producto.getid(), actualizar);
		
			
		
		
		}
		
		   
	}
	
	

}
