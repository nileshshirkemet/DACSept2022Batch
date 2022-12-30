package com.met.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Type;

@Entity(name = "Account_Tbl")
public class Account {

	@Id
	@Column(name = "acc_id")
	@GeneratedValue
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(length = 20)
	
	@Size(min = 3, message = "Name should be minimum 3 characters")
	private String name;
	private double balance;
	
	@Type(type = "yes_no")				//true_false
	@Column(nullable = true)
	private boolean active;
	
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	@Transient
	private double interest;
	
	public double getInterest() {
		return interest;
	}
	
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", balance=" + balance + ", active=" + active + ", interest="
				+ interest + "]";
	}
	
	
	
}
