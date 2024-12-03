package com.example.SpringJDBC.Service;

import com.example.SpringJDBC.Model.Product;
import com.example.SpringJDBC.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public void addProduct(Product s){
        repo.save(s);
    }

    public List<Product> getProducts() {
        return repo.findAll();
    }

    public void addInitialProducts(List<Product> productList) {
        repo.saveAll(productList);
    }
}
