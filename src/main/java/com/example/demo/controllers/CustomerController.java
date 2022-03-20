package com.example.demo.controllers;

import com.example.demo.data.Customer;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    static final String BASE_URL = "api/v1/customers";

    @GetMapping(path = "/")
    public Iterable<Customer> getHello() {
        return customerRepository.findAll();
    }

    @GetMapping(path = "/save")
    public Customer saveCustomer() {
        return  customerRepository.save(new Customer("Golan","Hadad"));
    }


    @GetMapping(path = "/id/{id}")
    public Customer getCustomerById(@PathVariable Long id) {
        return new Customer("Golan","Hadad");
    }
}