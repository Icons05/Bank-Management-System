package com.icons.model;

import javax.persistence.Entity;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

//import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import java.util.Date;

import javax.persistence.Column;

import com.icons.util.JsonDate;

@Entity
@Table(name = "CLIENT")
public class Client implements java.io.Serializable {
	@Id
	@Column(name = "CLIENT_ID")
	@GeneratedValue(generator = "CLIENT_SEQ")
	@SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ", allocationSize = 1)
	private int clientId;

	@Column(name = "CLIENT_NAME")
	private String name;

	@Column(name = "ACCOUNTNUMBER")
	private String accountNumber;

	@Column(name = "BALANCE")
	private Double balance;

	@Column(name = "OUTSTANDINGAMOUNT")
	private Double outstandingAmount;

	@Column(name = "DOJ")
	@JsonDeserialize(using = JsonDate.class)
	private Date doj;

	public Client() {
		super();
	}

	public Client(String name, String accountNumber, Double balance, Double outstandingAmount,
			Date doj) {
		super();
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.outstandingAmount = outstandingAmount;
		this.doj = doj;
	}

	public Client(int clientId, String name, String accountNumber, Double balance,
			Double outstandingAmount, Date doj) {
		super();
		this.clientId = clientId;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.outstandingAmount = outstandingAmount;
		this.doj = doj;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Double getBalance() {
		return this.balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getOutstandingAmount() {
		return this.outstandingAmount;
	}

	public void setOutstandingAmount(Double outstandingAmount) {
		this.outstandingAmount = outstandingAmount;
	}

	public Date getDoj() {
		return this.doj;
	}

	public void setDoj(Date doj) {
		this.doj = doj;
	}

	@Override
	public String toString() {
		return "ClientServiceImpl [clientId=" + clientId + ", name=" + name + ", accountNumber="
				+ accountNumber + ", balance=" + balance + ", outstandingAmount=" + outstandingAmount + ", doj=" + doj
				+ "]";
	}

}
