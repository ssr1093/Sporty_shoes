package com.sportyshoes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.Products;
import com.sportyshoes.service.ProductService;


@RestController
@RequestMapping("/")
@CrossOrigin 
public class Productcontroller {

	@Autowired
	private ProductService productservice;
	
	@PostMapping("/product")
	public Products createProduct(@RequestBody Products product) {
		
		return productservice.createProduct(product);
	}

    @GetMapping("/products")
	public List<Products> getAllProducts() {
		
		return productservice.getAllProducts();
	}
    
    @DeleteMapping(value = "/product/{productId}")
    public void deleteByProductId(@PathVariable int productId) {
    	productservice.deleteByProductId(productId);
    }
    
    @GetMapping(value = "/product/{productId}")
    public Products findByProductId(@PathVariable int productId) {
    	
    	return productservice.findByProductId(productId);
    }
    
    @PutMapping("/product")
    public Products updateProduct(@RequestBody Products product) {
    	
    	return productservice.updateProduct(product);
    }
    
    @GetMapping(value = "/products/{productCategory}")
    public List<Products> findByProductCategory(@PathVariable String productCategory) {
    	
    	return productservice.findByProductCategory(productCategory);
    }
}
