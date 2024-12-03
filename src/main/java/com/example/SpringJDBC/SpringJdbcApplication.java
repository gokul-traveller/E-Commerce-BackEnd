package com.example.SpringJDBC;

import com.example.SpringJDBC.Data.DBinitialData;
import com.example.SpringJDBC.Service.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
		ProductService productService = context.getBean(ProductService.class);
		DBinitialData dBinitialData = context.getBean(DBinitialData.class);
		productService.addInitialProducts(dBinitialData.getProducts());
	}

}
