package com.example.SpringJDBC.Service;

import com.example.SpringJDBC.Model.Customer;
import com.example.SpringJDBC.Model.CustomerPrincipal;
import com.example.SpringJDBC.Repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements UserDetailsService {

    @Autowired
    private CustomerRepo repo;
    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @Override
    public UserDetails loadUserByUsername(String user) throws UsernameNotFoundException {
        System.out.println(repo.findByUserEmail(user)+"from repo");
        Customer customer = repo.findByUserEmail(user);
        if (customer == null) {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }
        return new CustomerPrincipal(customer);
    }

    public List<Customer> getCustomer() {
        return repo.findAll();
    }

    public Optional<Customer> findUserById(String e_mail) {
        return repo.findById(e_mail);
    }

    public Customer addCustomer(Customer customer) {
        customer.setUserPassword(encoder.encode(customer.getUserPassword()));
        return repo.save(customer);
    }

    public Customer encodeCustomer(String e_mail) {

        Customer customer = repo.findByUserEmail(e_mail);
        customer.setUserPassword(encoder.encode(customer.getUserPassword()));
        return repo.save(customer);
    }

}
