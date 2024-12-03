package com.example.SpringJDBC.Controller;

import com.example.SpringJDBC.Model.Customer;
import com.example.SpringJDBC.Model.Product;
import com.example.SpringJDBC.Service.CustomerService;
import com.example.SpringJDBC.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/hello")
    public List<Product> greet(){
        return productService.getProducts();
    }


    @PostMapping("/getUser/{e_mail}")
    public Customer findUserById(@PathVariable("e_mail") String e_mail) {
        System.out.println(e_mail);
        Customer customerList = customerService.findUserById(e_mail).orElse(new Customer());
        System.out.println(customerList);
        return customerList;
    }

    @PostMapping("/getProducts")
    public List<Product> getAllProducts() {
        return productService.getProducts();
    }

}
