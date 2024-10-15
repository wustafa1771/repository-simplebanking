package com.eteration.simplebanking.services;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.InitBinder;

import com.eteration.simplebanking.model.Account;
import com.eteration.simplebanking.model.Transaction;

@Service
public class AccountService {

	public static ArrayList<Account> accounts = null;
	public static Account currentAccount=null;
	@PostConstruct
	public void postConstructRoutine() {
		accounts = new ArrayList<Account>();
		Account acc= new Account("mustafa", "669-7788");
		accounts.add(acc);
		currentAccount = acc;
	}
	
	public boolean credit(Transaction TRX, String accNum) {
		Account accSearch = null;
		for (Account index : accounts ) {
			   if(index.getAccountNumber().equals(accNum))
			   {
				   accSearch = index;
				   currentAccount = index;
			   }
			   break;
		   }
		if(accSearch!=null) {
			accSearch.post(TRX);
			return true;
		}else {
			return false;
		}
	}
	public String getTransactions(String accNum) {
		
		Account accSearch = null;
		for (Account index : accounts ) {
			   if(index.getAccountNumber().equals(accNum))
			   {
				   accSearch = index;
				   currentAccount = index;
			   }
			   break;
		   }
		if(accSearch!=null) {
			return accSearch.toString();
		}else {
			return "account not found";
		}
	}

	public void findAccount(String accNum) {
		Account accSearch = null;

		for (Account index : accounts ) {
			   if(index.getAccountNumber().equals(accNum))
			   {
				   accSearch = index;
				   currentAccount = index;
			   }
			   break;
		   }		
	}
}