package com.met.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employee {							//Source ENtity

	@Id
	@GeneratedValue
	private int id;
	
	@Column(length = 12)
	private String name;
	
	@Column(length = 20)
	private String emailId;
	
	@OneToMany(cascade = CascadeType.ALL, targetEntity = Address.class, mappedBy = "employee")
	//@JoinColumn(name = "fk_emp_id")
	private List<Address> listAddress;				//Target ENtity

	public List<Address> getListAddress() {
		return listAddress;
	}

	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", emailId=" + emailId + "]";
	}
	
	
	
}
