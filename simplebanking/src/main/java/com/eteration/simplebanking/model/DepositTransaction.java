package com.eteration.simplebanking.model;

import java.time.LocalDate;

// This class is a place holder you can change the complete implementation
public class DepositTransaction  extends Transaction{
	public DepositTransaction(double amount) {
		super.setAmount(amount);
		super.setDate(LocalDate.now());

	}
	public double getAmount() {
		return super.getAmount();
	}
	public void setAmount(double amount) {
		super.setAmount(amount);
	}
	
	
}