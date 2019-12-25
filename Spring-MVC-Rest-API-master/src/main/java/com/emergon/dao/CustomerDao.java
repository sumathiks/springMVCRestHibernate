package com.emergon.dao;

import com.emergon.entities.Customer;
import java.util.List;

public interface CustomerDao {

    Customer findById(int id);

    int save(Customer customer);

    //void remove(Customer customer);

    //Customer update(Customer customer);

    List<Customer> findAll();

    void remove(int id);

    public List<Customer> findLikeName(String searchName);

    public void update(int id, Customer customer);
}
