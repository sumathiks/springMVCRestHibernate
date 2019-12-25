package com.emergon.service;

import com.emergon.dao.CustomerDao;
import com.emergon.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional//Takes care of transactions automatically
@Service("customerService")//Applied to Service Implementations
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao cdao;

    @Override
    public Customer findById(int id) {
        return cdao.findById(id);
    }

    @Override
    public int saveCustomer(Customer customer) {
        return cdao.save(customer);
    }

    @Override
    public void removeCustomer(int id) {
        cdao.remove(id);
    }

    @Override
    public List<Customer> findAllCustomers() {
        return cdao.findAll();
    }

    @Override
    public List<Customer> searchCustomers(String searchName) {
        return cdao.findLikeName(searchName);
    }

    @Override
    public void update(int id, Customer customer) {
        cdao.update(id, customer);
    }
}
