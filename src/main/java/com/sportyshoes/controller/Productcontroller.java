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
	
	@PostMapping("/product/new") // admin only can use
	public Products createProduct(@RequestBody Products products) {
		
		return productservice.createProduct(products);
	}
//for users and admin
    @GetMapping("/products")
	public List<Products> getAllProducts() {
		
		return productservice.getAllProducts();
	}
    // only admin
    @DeleteMapping(value = "/product/{productid}")
    public void deleteByProductId(@PathVariable long productid) {
    	productservice.deleteByProductId(productid);
    }
    // for admin and users
    @GetMapping(value = "/product/{productid}")
    public Products findByProductId(@PathVariable long productid) {
    	
    	return productservice.findByProductId(productid);
    }
    //for admin
    @PutMapping("/product/edit")
    public Products updateProduct(@RequestBody Products product) {
    	
    	return productservice.updateProduct(product);
    }
    // for user and admin
    @GetMapping(value = "/products/{productcategory}")
    public List<Products> findByProductCategory(@PathVariable String productcategory) {
    	
    	return productservice.findByProductCategory(productcategory);
    }
}
