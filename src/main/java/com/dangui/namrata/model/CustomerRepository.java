package com.dangui.namrata.model;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository  extends MongoRepository<Customer, String> {
    /**
     *
     * @param firstName
     * @return
     */
    public Customer findByFirstName(String firstName);

    /**
     *
     * @param lastName
     * @return
     */
    public List<Customer> findByLastName(String lastName);
}
