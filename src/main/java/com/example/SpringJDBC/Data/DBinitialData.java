package com.example.SpringJDBC.Data;

import com.example.SpringJDBC.Model.Product;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
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

    private byte[] getImageDat(String image){
        File imageFile = new File("C:\\Users\\gokul.gopinath\\Downloads\\SpringJDBC\\SpringJDBC\\src\\main\\resources\\"+image);
        try {
            byte[] returnVal = Files.readAllBytes(imageFile.toPath());
            System.out.println(Arrays.toString(returnVal));
            return returnVal;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
