package com.eteration.simplebanking.model;

import java.util.ArrayList;

import com.eteration.simplebanking.controller.TransactionStatus;

// This class is a place holder you can change the complete implementation
public class Account {
	private String owner;
	private String accountNumber;
	private double balance;
	private ArrayList<Transaction> transactions;
	public Account(String owner, String accountNumber) {
		this.owner=owner;
		this.accountNumber = accountNumber;
		this.balance=0;
		this.transactions = new ArrayList<Transaction>();
	}
	
	public void post(Transaction trx) {
		try {
			if(trx instanceof DepositTransaction) {
				trx.setType("DepositTransaction");
				this.deposit(trx.getAmount());
			}
			else if (trx instanceof WithdrawalTransaction) {
				trx.setType("WithdrawalTransaction");

				this.withdraw(trx.getAmount());
			}
			transactions.add(trx);
		} catch (Exception e) {
		}
		
	}
	public void deposit(double amount){
		balance += amount;
	}
	public void withdraw(double amount) throws InsufficientBalanceException{
		if((balance -= amount)<0) {
			throw new InsufficientBalanceException();
		}
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double ballance) {
		this.balance = ballance;
	}

	public ArrayList<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(ArrayList<Transaction> transactions) {
		this.transactions = transactions;
	}

	@Override
	public String toString() {
		return "Account [owner=" + owner + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", transactions=" + transactions.toString() + "]";
	}
	
	
	
}
