package com.prueba.modelo;

public class Precios {
	private String codigoProducto;
	private int precioVentaPesos;
	private int precioCompraPesos;
	private int id;
	
	
	public Precios() {
		
		
		
	}

	
	public Precios (String codigoProducto, int precioVentaPesos , int precioCompraPesos, int id) {
		this.codigoProducto = codigoProducto;
		this.precioVentaPesos = precioVentaPesos;
		this.precioCompraPesos = precioCompraPesos;
		this.id = id;
			
	}

	
	public String getCodigoProducto() {
		return codigoProducto;
	}
	
	public void setCodigoProducto(String CodigoProducto) {
		this.codigoProducto = CodigoProducto;
	}
		
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public int getprecioVentaPesos() {
		return precioVentaPesos;
	}
	
	public void setprecioVentaPesos(int  precioVentaPesos) {
		this.precioVentaPesos = precioVentaPesos;
	}
	
	
	
	
	public int getprecioCompraPesos() {
		return precioCompraPesos;
	}
	
	public void setPrecioCompraPesos(int  precioCompraPesos) {
		this.precioCompraPesos = precioCompraPesos;
	}
	
	
	
	
	
}
	
	

