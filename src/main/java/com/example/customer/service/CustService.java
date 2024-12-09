package com.example.customer.service;

import com.example.customer.entity.Customer;

import java.util.List;


public interface CustService {

    List<Customer> fetchAllcustomers();
    Customer fetchById(Long id);
    Customer createCustomer(Customer customer);
    Customer updateCustomer(Customer customer);
    String deleteCustomer(Customer customer);
}
