package shopping;

import java.util.*;

public class OrderEntity implements java.io.Serializable {

	private int orderNo;

	private Date orderDate;

	private String customerId;

	private int productNo;

	private int quantity;

	public int getOrderNo() { return orderNo; }
	public void setOrderNo(int value) { orderNo = value; }

	public Date getOrderDate() { return orderDate; }
	public void setOrderDate(Date value) { orderDate = value; }

	public String getCustomerId() { return customerId; }
	public void setCustomerId(String value) { customerId = value; }

	public int getProductNo() { return productNo; }
	public void setProductNo(int value) { productNo = value; }

	public int getQuantity() { return quantity; }
	public void setQuantity(int value) { quantity = value; }

}

