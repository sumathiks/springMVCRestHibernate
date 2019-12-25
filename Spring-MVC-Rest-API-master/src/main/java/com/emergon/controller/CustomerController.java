package com.emergon.controller;

import com.emergon.entities.Customer;
import com.emergon.service.CustomerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//Used from Dispatcher Servlet to pass requests and get responses
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/")
    public String welcome() {//Welcome page, non-rest
        return "Welcome to RestTemplate Example.";
    }

   @GetMapping("/customers")
    public ResponseEntity<List<Customer>> list() {
        List<Customer> customers = customerService.findAllCustomers();
        return ResponseEntity.ok().body(customers);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> get(@PathVariable("id") int id) {
        Customer customer = customerService.findById(id);
        return ResponseEntity.ok().body(customer);
    }

    /*---Add new customer---*/
    @PostMapping("/customers")
    public ResponseEntity<?> save(@RequestBody Customer customer) {
        int id = customerService.saveCustomer(customer);
        return ResponseEntity.ok().body("New Customer has been saved with ID:" + id);
    }

    /*---Update a customer by id---*/
    @PutMapping("/customers/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Customer customer) {
        customerService.update(id, customer);
        return ResponseEntity.ok().body("Customer has been updated successfully.");
    }

    /*---Delete a customer by id---*/
    @DeleteMapping("/customers/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        customerService.removeCustomer(id);
        return ResponseEntity.ok().body("Customer has been deleted successfully.");
    }

    @GetMapping("/customers/name/{searchName}")
    public ResponseEntity<List<Customer>> searchCustomers(@PathVariable("searchName") String searchName) {
        List<Customer> customers = customerService.searchCustomers(searchName);
        return ResponseEntity.ok().body(customers);
    }

}
