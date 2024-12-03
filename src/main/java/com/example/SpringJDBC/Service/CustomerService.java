package com.example.SpringJDBC.Service;

import com.example.SpringJDBC.Model.Customer;
import com.example.SpringJDBC.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo repo;

    public List<Customer> getCustomer() {
        return repo.findAll();
    }

    public Optional<Customer> findUserById(String e_mail) {
        return repo.findById(e_mail);
    }
}
