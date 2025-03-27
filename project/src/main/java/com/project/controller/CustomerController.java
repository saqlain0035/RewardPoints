package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Customer;
import com.project.service.CustomerService;

import jakarta.validation.Valid;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer")
	public ResponseEntity<Customer> addCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<>(this.customerService.addCustomer(customer), HttpStatus.OK);
	}
}
