package com.prueba.Dao;

import java.util.List;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.conexion.ConexionJava;
import com.prueba.InterfaceDao.IProductoDao ;
import com.prueba.InterfaceDao.IProductoDao;
import java.util.ArrayList;

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
	
	
	

}
