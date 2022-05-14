package com.sportyshoes.service;

import java.util.Date;
import java.util.List;

import com.sportyshoes.entity.Products;
import com.sportyshoes.entity.Purchase;

public interface Purchaseservice {

	
	public Purchase createPurchase(Purchase purchase);
	public List<Purchase> getAllPurchases();
	public Purchase findByPurchaseId(int purchaseId);
	public List<Products> findByProductCategory(String productCategory);
	public List<Purchase> findByPurchaseDate(Date purchaseDate);
}
