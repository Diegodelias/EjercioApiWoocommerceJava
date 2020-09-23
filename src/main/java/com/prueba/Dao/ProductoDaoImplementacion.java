package com.prueba.Dao;

import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexion.ConexionJava;
import com.icoderman.woocommerce.ApiVersionType;
import com.icoderman.woocommerce.EndpointBaseType;
import com.icoderman.woocommerce.WooCommerce;
import com.icoderman.woocommerce.WooCommerceAPI;
import com.icoderman.woocommerce.oauth.OAuthConfig;
import com.prueba.InterfaceDao.IProductoDao ;
import com.prueba.InterfaceDao.IProductoDao;
import java.util.ArrayList;
import java.util.HashMap;

import com.prueba.modelo.Order;
import com.prueba.modelo.Producto;

public class ProductoDaoImplementacion implements IProductoDao {

	public boolean actualizar(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	public List<Producto> obtener() {
	
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		String sql="SELECT * FROM productos";
		List<Producto> listaProducto= new ArrayList<Producto>();
		try {			
			co= ConexionJava.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Producto c=new Producto();
				c.setCodigoProducto(rs.getString(1));
				c.setDescripcionProducto(rs.getString(2));
				c.setid(rs.getInt(3));
				
				listaProducto.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase ProductoDaoImplementacion, método obtener");
			e.printStackTrace();
		}
		
		return listaProducto;
		}
	
	
	
	
	
	///////

	@Override
	public boolean GetOrders() throws FileNotFoundException, IOException {
		 final String GuardarArchivo = "C:\\reportes\\";
		 final String NombreArchivo = "ReporteOrdenes.xlsx";
		///////////////////
		 OAuthConfig config = new OAuthConfig("http://c1830079.ferozo.com", "ck_11bf7cb735d7aa2fc586a61fcdabe812ce34a0ec", "cs_4dfc94158dd9dc187251d6cec85272925fbacb79");
		 WooCommerce wooCommerce = new WooCommerceAPI(config, ApiVersionType.V3);
			  
			
			   Map<String, String> params = new HashMap<String, String>();
			   params.put("per_page","100");
			   params.put("offset","0");
			   List<Map<String, Object>> orders = wooCommerce.getAll(EndpointBaseType.ORDERS.getValue(), params);
			
			   ArrayList<Order> listaOrdenes = new ArrayList<Order>();
			
			   
			   for (int contador=0; contador < orders.size(); contador++) {
				   	 Order orden = new Order();
				   	 String IdTemp = (String) orders.get(contador).get("number");
				     String tempStatus = (String) orders.get(contador).get("status");
				     String tempOrderKey = (String) orders.get(contador).get("order_key");
				     String tempTotal = (String) orders.get(contador).get("total");
				     orden.setStatus(tempStatus);
				     orden.setOrder_key(tempOrderKey);
				     orden.setTotal(tempTotal );
				     orden.setid(IdTemp);
				     listaOrdenes.add(orden);}
			  
			
			  
			 		// crear workbook
					XSSFWorkbook workbook = new XSSFWorkbook();
					// creating sheet with name "Report" in workbook
					XSSFSheet sheet = workbook.createSheet("Report");
					//crear encabezado tabla y tamaño
					sheet.setColumnWidth(90, 90 * 256);
					createHeader(sheet, workbook);

					int rowCount = 0;
					for (Order order : listaOrdenes ) {
						//crear fila
						Row row = sheet.createRow(++rowCount);
						
						// agregar primer celda a la fila
						Cell idCell = row.createCell(0);
						idCell.setCellValue(order.getid());
						sheet.autoSizeColumn(0);
						
						// agregar segunda celda a la fila
						Cell nameCell = row.createCell(1);
						nameCell.setCellValue(order.getOrder_key());
						sheet.autoSizeColumn(1);
						
						
						Cell statusCell = row.createCell(2);
						statusCell.setCellValue(order.getStatus());
						sheet.autoSizeColumn(2);
				
						Cell totalCell = row.createCell(3);
						totalCell.setCellValue(order.getTotal());
						sheet.autoSizeColumn(3);

					}
					try (FileOutputStream outputStream = new FileOutputStream(GuardarArchivo + NombreArchivo)) {
						workbook.write(outputStream);
					}

			 
		 
		 
		 
		 //////////////////////
		 
		 return true;
		
		

	

}

	
	
	private static void createHeader(XSSFSheet sheet, XSSFWorkbook workbook) {
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Order key");
		headerRow.createCell(2).setCellValue("Status");
		headerRow.createCell(3).setCellValue("Total");
	}


	
	
	
	
}	
	