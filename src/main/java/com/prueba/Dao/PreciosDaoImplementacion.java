package com.prueba.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conexion.ConexionJava;
import com.prueba.InterfaceDao.IPreciosDao;
import com.prueba.modelo.Precios;
import com.prueba.modelo.Producto;

public class PreciosDaoImplementacion implements IPreciosDao {

	@Override
	public boolean actualizar(Precios precio) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Precios> obtener() {
		
		
		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		String sql="SELECT * FROM precios";
		List<Precios> listaPrecios= new ArrayList<Precios>();
		try {			
			co= ConexionJava.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Precios c=new Precios();
				c.setCodigoProducto(rs.getString(1));
				
				c.setprecioVentaPesos(rs.getInt(2));
			
				c.setPrecioCompraPesos(rs.getInt(3));
			
				c.setid(rs.getInt(4));
			
				
				listaPrecios.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase PreciosDaoImplementacion, método obtener");
			e.printStackTrace();
		}
		
		return listaPrecios;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}


