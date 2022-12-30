package com.met.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "CHEQUE")
public class ChequePayment extends Payment {

	@Column(length = 15)
	private String chequeNo;
	
	@Column(length = 15)
	private String bankName;

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", bankName=" + bankName + ", getAmount()=" + getAmount()
				+ ", getTransDate()=" + getTransDate() + ", getId()=" + getId() + "]";
	}
	
	
	
}
