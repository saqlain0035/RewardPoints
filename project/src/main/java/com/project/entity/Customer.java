package com.project.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long customerId;
	
	@NotEmpty(message = "Customer Name can't be empty")
	private String name;
	
	@NotEmpty(message = "Customer Phone Number can't be empty")
	@Column(length = 10)
	private String phoneNo;
	
	@NotEmpty(message = "Customer Address can't be empty")
	private String address;
	
	@Transient
	private int points=0;
}
