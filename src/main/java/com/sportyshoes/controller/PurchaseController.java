package com.sportyshoes.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportyshoes.entity.Products;
import com.sportyshoes.entity.Purchase;
import com.sportyshoes.service.Purchaseservice;

@RestController
@RequestMapping("/")
@CrossOrigin 
public class PurchaseController {
	
	@Autowired
	private Purchaseservice purchaseservice;
	//only user can purchase
	@PostMapping("/purchase")
	public Purchase createPurchase(@RequestBody Purchase purchase) {
		
		return purchaseservice.createPurchase(purchase);
	}
//only admin and user for only user purchase
    @GetMapping("/purchase/list")
	public List<Purchase> getAllPurchases() {
		
		return purchaseservice.getAllPurchases();
	}
//user and admin
    @GetMapping(value = "/purchase/{purchaseid}")
    public Purchase findByPurchaseId(@PathVariable long purchaseid) {
    	
    	return purchaseservice.findByPurchaseId(purchaseid);
    }
    
// user and admin    
    @GetMapping(value = "/purchases/{purchaseCategory}")
    public List<Products> findByProductCategory(@PathVariable String purchasecategory) {
    	
    	return purchaseservice.findByProductCategory(purchasecategory);
    }
//user and admin
    @GetMapping(value = "/purchases/{purchaseDate}")
    public List<Purchase> findByPurchaseDate(@PathVariable Date purchaseDate) {
    	
    	return purchaseservice.findByPurchaseDate(purchaseDate);
    }
}
