package com.prueba.modelo;

public class Order {
	private String id;
	private String order_key;
	private String status;
	private String total;
	
	
	
	public Order() {
		
		
	}
	
	
	public Order(String id , String order_key ,String status , String total) {
		this.id = id;
		this.order_key = order_key;
		this.status= status;
		this.total = total;
	}
	
	public String getid() {
		return id;
	}
	
	public void setid(String id) {
		this.id = id;
	}

	
	public String getOrder_key() {
		return order_key;
	}
	
	public void setOrder_key(String order_key) {
		this.order_key = order_key;
	}
	
	
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	public String getTotal() {
		return total;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}
	
	
	

}
