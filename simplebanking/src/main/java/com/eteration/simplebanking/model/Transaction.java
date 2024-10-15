package com.eteration.simplebanking.model;

import java.time.LocalDate;

// This class is a place holder you can change the complete implementation
public abstract class Transaction {
	private LocalDate date;
	private double amount;
	private String type;
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Transaction [date=" + date + ", amount=" + amount + ", type=" + type + "]";
	}
	
}
