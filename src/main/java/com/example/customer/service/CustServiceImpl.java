package com.example.customer.service;

import com.example.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.customer.repository.CustomerRepository;

import java.util.List;
@Service
public class CustServiceImpl implements CustService  {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> fetchAllcustomers() {
        return (List<Customer>) customerRepository.findAll();
    }
    @Override
    public Customer fetchById(Long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public String deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
        return "Customer deleted for id" + customer.getId();
    }
}
