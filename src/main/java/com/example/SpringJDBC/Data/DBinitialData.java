package com.example.SpringJDBC.Data;

import com.example.SpringJDBC.Model.Product;
import lombok.Getter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Getter
@Component
public class DBinitialData {
    DBinitialData(){
        initialize();
    }

    private  List<Product> products = new ArrayList<>();

    private void initialize() {
        // Adding sample products using the constructor
        products.add(new Product(
                101,
                "Brand",
                "Product A",
                "Description of Product A",
                100,
                50,
                "productA.jpg",
                "image/jpeg",
                getImageDat("abstractWallpaper.jpg")
        ));
        products.add(new Product(
                102,
                "Brand",
                "Product B",
                "Description of Product B",
                200,
                30,
                "productB.jpg",
                "image/jpeg",
                getImageDat("images (1).jpg")
        ));
        products.add(new Product(
                103,
                "Brand",
                "Product C",
                "Description of Product C",
                300,
                20,
                "productC.jpg",
                "image/png",
                getImageDat("abstractWallpaper.jpg")
        ));
        products.add(new Product(
                104,
                "Brand",
                "Product D",
                "Description of Product D",
                400,
                10,
                "productD.jpg",
                "image/png",
                getImageDat("images (1).jpg")
        ));
    }

    private byte[] getImageDat(String image) {
        try {
            ClassPathResource imgFile = new ClassPathResource(image);
            try (InputStream inputStream = imgFile.getInputStream();
                 ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {

                int nRead;
                byte[] data = new byte[16384]; // 16 KB buffer

                while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }

                return buffer.toByteArray();
            }
        } catch (IOException e) {
            throw new RuntimeException("File not found: " + image, e);
        }
    }
}
