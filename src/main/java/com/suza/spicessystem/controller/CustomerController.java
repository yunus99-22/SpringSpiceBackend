package com.suza.spicessystem.controller;

import com.suza.spicessystem.model.Customer;
import com.suza.spicessystem.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*" ,allowedHeaders = "*")
@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {
    @Autowired
//    public CustomerService customerService;
    public CustomerRepository customerRepository;

    @Autowired
    public CustomerController( CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @PostMapping("add")
    public Customer createCustomer(@RequestBody Customer customer){return customerRepository.save(customer);}



    @GetMapping("/GetAll")
    public ResponseEntity<?> getAll() {
        try {
            List<Customer> customerList = customerRepository.findAll();

            if (customerList.isEmpty()) {
                return new ResponseEntity<>("umekosea", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(customerList, HttpStatus.OK);
            }
        } catch (Exception ex) {
            return new ResponseEntity<>("NetworkError", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/GETBYID/{id}")
    public Optional<Customer> getCustomer(@PathVariable Integer id) {
        return customerRepository.findById(id);
    }

    @DeleteMapping("/DELETE/{id}")
    public String deleteCustomer(@PathVariable Integer id){
        Customer deleteCustomer=customerRepository.findById(id).get();
        customerRepository.delete(deleteCustomer);
        return "customerDeleted";
    }
    @PutMapping("/Update/{id}")
        public String updateCustomer(@PathVariable Integer id,@RequestBody Customer customer){
        Customer updatedCustomer =customerRepository.findById(id).get();
        updatedCustomer.setName(customer.getName());
        updatedCustomer.setAddress(customer.getAddress());
        updatedCustomer.setEmail(customer.getEmail());
        customerRepository.save(updatedCustomer);
        return "updated";
    }








    }







