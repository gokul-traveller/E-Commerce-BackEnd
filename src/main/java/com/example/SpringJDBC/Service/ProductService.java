package com.example.SpringJDBC.Service;

import com.example.SpringJDBC.Model.Product;
import com.example.SpringJDBC.Model.ProductDTO;
import com.example.SpringJDBC.Repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public void addProduct(Product s){
        repo.save(s);
    }

    public List<ProductDTO> getProducts() {
        List<Product> products = repo.findAll();
        return products.stream().map(ProductDTO::new).collect(Collectors.toList()); // Convert to DTOs
    }

    public void addInitialProducts(List<Product> productList) {
        repo.saveAll(productList);
    }
}
