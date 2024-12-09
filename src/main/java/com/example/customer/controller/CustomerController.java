package com.example.customer.controller;

import com.example.customer.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.customer.service.CustService;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustService custService;

    @GetMapping("/api/v1/customers")
    public ResponseEntity<List<Customer>> fetchAllCustomers() {
        return ResponseEntity.ok(custService.fetchAllcustomers());
    }

    @GetMapping("/api/v1/customers/{id}")
    public ResponseEntity<Customer> fetchById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(custService.fetchById(id));
    }

    @PostMapping("/api/v1/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        return ResponseEntity.ok(custService.createCustomer(customer));
    }

    @PutMapping("/api/v1/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") Long id,@RequestBody Customer customer) {
        Customer custObj = custService.fetchById(id);
        if (custObj != null) {
        custObj.setName(customer.getName());
        custObj.setAddress(customer.getAddress());
        custObj.setEmail(customer.getEmail());
        }

        return ResponseEntity.ok(custService.updateCustomer(custObj));
    }

    @DeleteMapping("/api/v1/customers/{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long id) {
        Customer custObj = custService.fetchById(id);
        String deleteMsg = null;
        if (custObj != null) {
            deleteMsg = custService.deleteCustomer(custObj);
        }

        return ResponseEntity.ok(deleteMsg);
    }
}
