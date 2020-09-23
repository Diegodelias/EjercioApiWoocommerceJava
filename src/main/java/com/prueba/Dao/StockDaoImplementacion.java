package com.prueba.Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.conexion.ConexionJava;
import com.prueba.InterfaceDao.IStockDao;
import com.prueba.modelo.Precios;
import com.prueba.modelo.Stock;

public class StockDaoImplementacion implements IStockDao {

	@Override
	public List<Stock> obtener() {

		Connection co =null;
		Statement stm= null;
		ResultSet rs=null;
		String sql="SELECT * FROM stock";
		List<Stock> stock= new ArrayList<Stock>();
		try {			
			co= ConexionJava.conectar();
			stm=co.createStatement();
			rs=stm.executeQuery(sql);
			while (rs.next()) {
				Stock c=new Stock();
				c.setCodigoProducto(rs.getString(1));
				
				c.setStockDisponible(rs.getInt(2));
				
				c.setid(rs.getInt(3));
				
				
				stock.add(c);
			}
			stm.close();
			rs.close();
			co.close();
		} catch (SQLException e) {
			System.out.println("Error: Clase StockDaoImplementacion, método obtener");
			e.printStackTrace();
		}
		
		return stock;
		
		
		
		
		
		
		
		
	}

}
