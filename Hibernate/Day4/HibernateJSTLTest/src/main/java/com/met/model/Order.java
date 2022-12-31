package com.met.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "orders")
public class Order {

	@Id
	@Column(name = "ord_no")
	private int id;
	
	@Column(name = "pno")
	private int productNo;
	
	@Column(name = "qty")
	private int quantity;
	
	@Column(name = "ord_date")
	private java.sql.Date orderDate;
	
	@Column(name = "cust_id")
	private String custId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public java.sql.Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(java.sql.Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", productNo=" + productNo + ", quantity=" + quantity + ", orderDate=" + orderDate
				+ ", custId=" + custId + "]";
	}
	
	
	
}
