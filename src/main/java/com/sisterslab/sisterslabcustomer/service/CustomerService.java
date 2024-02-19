package com.sisterslab.sisterslabcustomer.service;

import com.sisterslab.sisterslabcustomer.model.Customer;
import com.sisterslab.sisterslabcustomer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomerService {
    private final CustomerRepository customerRepository;
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> allCustomer() {
        return customerRepository.findAll();
    }

    public Customer getCustomerFindById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            return customer.get();
        }
        else {
            log.info("Aradığınız ID de kullanıcı yoktur!");
            return null;
        }
    }

    public String updateFirstName(Long id, Customer customer) {
        Optional<Customer> customerOptional = customerRepository.findById(id);
        if (customerOptional.isPresent()){
            Customer oldCustomer = customerOptional.get();
            oldCustomer.setFirst_name(customer.getFirst_name());
            customerRepository.save(oldCustomer);
            return "İslem Başarılı";
        }

        return null;
    }

    public void deleteCustomerById(Long id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()){
            customerRepository.deleteById(id);
        }
        else {
            log.info("Aradığınız ID de kullanıcı yoktur!");
        }

    }
}
