package com.eteration.simplebanking.model;

import java.time.LocalDate;
import java.util.Date;

// This class is a place holder you can change the complete implementation
public class WithdrawalTransaction extends Transaction{
	public WithdrawalTransaction(double amount) {

		super.setAmount(amount);
		super.setDate(LocalDate.now());
	}
}


