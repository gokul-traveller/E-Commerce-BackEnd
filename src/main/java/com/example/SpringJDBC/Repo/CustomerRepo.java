package com.example.SpringJDBC.Repo;

import com.example.SpringJDBC.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

    Customer findByUserEmail(String user);
}
