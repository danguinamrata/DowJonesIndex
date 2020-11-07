package com.dangui.namrata.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dangui.namrata.model.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;


@RestController
public class BasicController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private CustomerRepository repository;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot";

    }

    @RequestMapping("/customer")
    public List<Customer> displayCustomer(){
        log.info("Showing Mongo Customer records .........................................");
        List<Customer> result = new ArrayList<Customer>();
        for(Customer customer: repository.findByLastName("Dangui") ) {
            result.add(customer);
        }
        //return String.join(" ", result);
        return result;
    }
}
