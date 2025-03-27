package com.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.entity.Transaction;
import com.project.exception.InvalidCustomerIdException;
import com.project.service.TransactionService;

import jakarta.validation.Valid;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/transaction")
	public ResponseEntity<String> addTransaction(@Valid @RequestBody Transaction transaction){
		try {
			return new ResponseEntity<>(this.transactionService.addTransaction(transaction), HttpStatus.OK);
		}
		catch (InvalidCustomerIdException e) {
			return new ResponseEntity<>("Customer Id entered is not present", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/allPoints")
	public ResponseEntity<List<Customer>> allPoints(){
		return new ResponseEntity<>(this.transactionService.allPoints(), HttpStatus.OK);
	}
	
	@GetMapping("/monthlyPoints/{str}")
	public ResponseEntity<List<Customer>> monthlyPoints(@PathVariable("str") String str){
		return new ResponseEntity<>(this.transactionService.monthlyPoints(str), HttpStatus.OK);
	}
}
