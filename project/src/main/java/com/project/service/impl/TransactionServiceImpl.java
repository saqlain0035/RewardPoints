package com.project.service.impl;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Customer;
import com.project.entity.Transaction;
import com.project.exception.InvalidCustomerIdException;
import com.project.repository.CustomerRepository;
import com.project.repository.TransactionRepository;
import com.project.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService{
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public String addTransaction(Transaction transaction) throws InvalidCustomerIdException{
		
		this.customerRepository.findById(transaction.getCustomerId()).orElseThrow(()->new InvalidCustomerIdException());
		this.transactionRepository.save(transaction);
		return "Data Inserted Sucessfully";
	}
	
	public int calculatePoints(double amount) {
		int points=0;
		if(amount>100)
			points=(int)(amount-100)*2+50;
		else if(amount>50)
			points=(int)amount-50;
		else
			points=0;
		return points;
	}
	
	@Override
	public List<Customer> allPoints() {
		List<Customer> customers=this.customerRepository.findAll();
		for(Customer customer:customers) {
			List<Transaction> transactions=this.transactionRepository.findByCustomerId(customer.getCustomerId());
			for(Transaction transaction:transactions) {
				customer.setPoints(customer.getPoints()+calculatePoints(transaction.getAmount()));
			}
		}
		return customers;
	}
	
	@Override
	public List<Customer> monthlyPoints(String str){
		String[] strArray=str.split(" ");
		Month month=Month.valueOf(strArray[0].toUpperCase());
		int year=Integer.parseInt(strArray[1]);
		LocalDate startDate = LocalDate.of(year, month, 1);
	    LocalDate endDate = startDate.withDayOfMonth(startDate.lengthOfMonth());
	    
	    List<Customer> customers=this.customerRepository.findAll();
		for(Customer customer:customers) {
			List<Transaction> transactions=this.transactionRepository.findByCustomerId(customer.getCustomerId());
			for(Transaction transaction:transactions) {
				if(!transaction.getDate().isBefore(startDate) && !transaction.getDate().isAfter(endDate))
					customer.setPoints(customer.getPoints()+calculatePoints(transaction.getAmount()));
			}
		}
		return customers;
	    
	}
}
