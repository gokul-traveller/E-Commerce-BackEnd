package com.example.SpringJDBC.Model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Base64;

@Data  // Lombok generates getters & setters automatically
@NoArgsConstructor
public class ProductDTO {
    private int productId;
    private String brand;
    private String name;
    private String description;
    private int price;
    private int stockQuantity;
    private String imageName;
    private String imageType;
    private String imageData; // Store image as Base64

    // Constructor to convert Product -> ProductDTO
    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.brand = product.getBrand();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        this.stockQuantity = product.getStockQuantity();
        this.imageName = product.getImageName();
        this.imageType = product.getImageType();
        this.imageData = Base64.getEncoder().encodeToString(product.getImageData()); // Convert byte[] to Base64 string
    }
}
