package com.eteration.simplebanking.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eteration.simplebanking.model.DebitRequest;
import com.eteration.simplebanking.model.DepositTransaction;
import com.eteration.simplebanking.model.Transaction;
import com.eteration.simplebanking.model.WithdrawalTransaction;
import com.eteration.simplebanking.services.AccountService;

@RestController
public class AccountController {
@Autowired
AccountService accService;
    
    @PostMapping("/account/v1/credit/{accountNumber}")
    public ResponseEntity<?> credit(@PathVariable String accountNumber,@RequestBody DebitRequest debit) {

    Transaction trx = new DepositTransaction(debit.getAmount());
    	boolean response =accService.credit( trx,  accountNumber);
    	if(response) {
            return new ResponseEntity<>("Money succesfully deposited", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @PostMapping("/account/v1/debit/{accountNumber}")
    public ResponseEntity<?> debit(@PathVariable String accountNumber,@RequestBody DebitRequest debit) {

    Transaction trx = new WithdrawalTransaction(debit.getAmount());
    	boolean response =accService.credit( trx,  accountNumber);
    	if(response) {
            return new ResponseEntity<>("MoneySuccessfully withdrawn", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Account not found", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/account/v1/{accountNumber}")
    public ResponseEntity<?> getAccount(@PathVariable String accountNumber) {
    
            return new ResponseEntity<>(accService.getTransactions(accountNumber), HttpStatus.OK);
      
    }

}
