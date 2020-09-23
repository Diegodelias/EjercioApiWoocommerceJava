package com.prueba.modelo;

public class Stock {
	private String CodigoProducto;
	private int StockDisponible;
	private int id;
	
	
	public Stock() {
		
		
	}

	public Stock(String CodigoProducto , int StockDisponible,int id) {
		this.CodigoProducto = CodigoProducto;
		this.StockDisponible = StockDisponible;
		this.id = id;
		
	}
	
	
	public String getCodigoProducto() {
		return CodigoProducto;
	}
	
	public void setCodigoProducto(String CodigoProducto) {
		this.CodigoProducto = CodigoProducto;
	}
	
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	
	public int getStockDisponible() {
		return StockDisponible;
	}
	
	public void setStockDisponible(int StockDisponible) {
		this.StockDisponible = StockDisponible;
	}
	
}
