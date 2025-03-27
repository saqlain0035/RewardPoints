package com.project.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.entity.Customer;
import com.project.entity.Transaction;
import com.project.exception.InvalidCustomerIdException;
import com.project.repository.CustomerRepository;
import com.project.repository.TransactionRepository;

@ExtendWith(MockitoExtension.class)
class TransactionServiceImplTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    private Customer customer;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setCustomerId(1);
        customer.setPoints(0);
        
        transaction = new Transaction();
        transaction.setCustomerId(1);
        transaction.setAmount(120);
        transaction.setDate(LocalDate.of(2024, Month.MARCH, 15));
    }

    @Test
    void testAddTransactionSuccess() throws InvalidCustomerIdException {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(transactionRepository.save(transaction)).thenReturn(transaction);

        String result = transactionService.addTransaction(transaction);
        
        assertEquals("Data Inserted Sucessfully", result);
        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void testAddTransactionInvalidCustomer() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(InvalidCustomerIdException.class, () -> transactionService.addTransaction(transaction));
    }

    @Test
    void testCalculatePoints() {
        assertEquals(90, transactionService.calculatePoints(120));
        assertEquals(50, transactionService.calculatePoints(100));
        assertEquals(10, transactionService.calculatePoints(60));
        assertEquals(0, transactionService.calculatePoints(40));
    }

    @Test
    void testAllPoints() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        when(transactionRepository.findByCustomerId(1)).thenReturn(Arrays.asList(transaction));

        List<Customer> customers = transactionService.allPoints();
        assertEquals(90, customers.get(0).getPoints());
    }

    @Test
    void testMonthlyPoints() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        when(transactionRepository.findByCustomerId(1)).thenReturn(Arrays.asList(transaction));

        List<Customer> customers = transactionService.monthlyPoints("March 2024");
        assertEquals(90, customers.get(0).getPoints());
    }
}
