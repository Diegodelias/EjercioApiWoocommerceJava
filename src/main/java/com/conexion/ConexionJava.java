package com.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionJava {
	
	public static Connection conectar() {
		Connection con = null;
		
		String password = "123456";
		String usuario = "root";
		String url = "jdbc:mysql://localhost:3314/mydb?&serverTimezone=GMT&user=" + usuario
				+ "&password=" + password ;
		try {
			con = DriverManager.getConnection(url);
			if (con != null) {
				System.out.println("Conectado");
			}
		} catch (SQLException e) {
			System.out.println("No se pudo conectar a la base de datos");
			e.printStackTrace();
		}
		return con;
	}

}
