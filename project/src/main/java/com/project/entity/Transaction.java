package com.project.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long transactionId;
	
	@NotNull(message = "Customer Id is missing")
	private long customerId;
	
	@NotEmpty(message = "Please provide Product Name")
	private String productName;
	
	@NotNull(message = "Please enter Transaction Amount")
	@Positive(message = "Transaction Amount can't be negative or zero")
	private double amount;
	
	@NotNull(message = "Provide Date of Transaction")
	@PastOrPresent(message = "The Transaction Date entered is of Future")
	private LocalDate date;
	
}
