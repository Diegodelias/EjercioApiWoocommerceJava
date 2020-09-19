package com.prueba.modelo;

public class Producto {
	private String CodigoProducto;
	private String DescripcionProducto;
	private int id;
	
	public Producto() {
		
		
	}
	
	
	public Producto(String CodigoProducto , String DescripcionProducto,int id) {
		this.CodigoProducto = CodigoProducto;
		this.DescripcionProducto = DescripcionProducto;
		this.id = id;
		
	}
	
	public String getCodigoProducto() {
		return CodigoProducto;
	}
	
	public void setCodigoProducto(String CodigoProducto) {
		this.CodigoProducto = CodigoProducto;
	}
	
	public String getDescripcionProducto() {
		return DescripcionProducto;
	}
	
	public void setDescripcionProducto(String DescripcionProducto) {
		this.DescripcionProducto = DescripcionProducto;
	}
 
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
}
