package com.example.SpringJDBC.Controller;

import com.example.SpringJDBC.Model.Customer;
import com.example.SpringJDBC.Model.Product;
//import com.example.SpringJDBC.Service.CustomerService;
import com.example.SpringJDBC.Service.CustomerService;
import com.example.SpringJDBC.Service.JwtService;
import com.example.SpringJDBC.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    @GetMapping("/hello")
    public List<Product> greet(){
        return productService.getProducts();
    }


    @GetMapping("/getUser/{e_mail}")
    public Customer findUserById(@PathVariable("e_mail") String e_mail) {
        System.out.println(e_mail+"from controller");
        Customer customerList = customerService.findUserById(e_mail).orElse(new Customer());
        System.out.println(customerList);
        return customerList;
    }

    @PostMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

    @PostMapping("/register")
    public Customer addCustomer(Customer customer) {
        return customerService.addCustomer(customer);
    }

    @PostMapping("/updatePassword")
    public Customer encodeCustomer(String e_mail) {
        return customerService.encodeCustomer(e_mail);
    }

    @PostMapping("/login")
    public String verifyCustomer(@RequestBody Customer customer) {
        System.out.println(customer);
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(customer.getUserEmail(), customer.getUserPassword()));
        if(authentication.isAuthenticated()) {
            return jwtService.generateToken(customer.getUserEmail());
        }
        return "login failed";
    }

}
