package com.met.model;

import java.sql.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
/*
 * @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
 * 
 * @DiscriminatorColumn(name = "type", length = 8)
 * 
 * @DiscriminatorValue(value = "CASH")
 */

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Inheritance(strategy = InheritanceType.JOINED)

public class Payment {

	@Id
	@GeneratedValue
	private int id;
	private double amount;
	
	//@Temporal(TemporalType.DATE)     required if date is from java.util.Date
	
	
	private Date transDate;
	
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "Payment [id=" + id + ", amount=" + amount + ", transDate=" + transDate + "]";
	}
	
	
	
}









