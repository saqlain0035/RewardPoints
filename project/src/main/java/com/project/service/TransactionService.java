package com.project.service;

import java.util.List;

import com.project.entity.Customer;
import com.project.entity.Transaction;
import com.project.exception.InvalidCustomerIdException;

public interface TransactionService {

	String addTransaction(Transaction transaction) throws InvalidCustomerIdException;

	List<Customer> allPoints();

	List<Customer> monthlyPoints(String str);

}
