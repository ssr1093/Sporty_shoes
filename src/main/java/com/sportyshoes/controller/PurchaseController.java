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
	
	@PostMapping("/purchase")
	public Purchase createPurchase(@RequestBody Purchase purchase) {
		
		return purchaseservice.createPurchase(purchase);
	}

    @GetMapping("/purchases")
	public List<Purchase> getAllPurchases() {
		
		return purchaseservice.getAllPurchases();
	}

    @GetMapping(value = "/purchase/{purchaseId}")
    public Purchase findByPurchaseId(@PathVariable int purchaseId) {
    	
    	return purchaseservice.findByPurchaseId(purchaseId);
    }
    

    
    @GetMapping(value = "/purchases/{purchaseCategory}")
    public List<Products> findByProductCategory(@PathVariable String purchaseCategory) {
    	
    	return purchaseservice.findByProductCategory(purchaseCategory);
    }

    @GetMapping(value = "/purchases/{purchaseDate}")
    public List<Purchase> findByPurchaseDate(@PathVariable Date purchaseDate) {
    	
    	return purchaseservice.findByPurchaseDate(purchaseDate);
    }
}
