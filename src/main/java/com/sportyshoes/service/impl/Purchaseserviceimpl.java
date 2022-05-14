package com.sportyshoes.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Products;
import com.sportyshoes.entity.Purchase;
import com.sportyshoes.repository.Purchaserepo;
import com.sportyshoes.service.Purchaseservice;
@Service
@Transactional
public class Purchaseserviceimpl implements Purchaseservice {

	@Autowired
	private Purchaserepo purchaserepo;
	
	@Override
	public Purchase createPurchase(Purchase purchase) {
		// TODO Auto-generated method stub
		return purchaserepo.save(purchase);
	}

	@Override
	public List<Purchase> getAllPurchases() {
		// TODO Auto-generated method stub
		return purchaserepo.findAll();
	}

	@Override
	public Purchase findByPurchaseId(int purchaseId) {
		// TODO Auto-generated method stub
		return purchaserepo.findByPurchaseId(purchaseId);
	}

	@Override
	public List<Products> findByProductCategory(String productCategory) {
		// TODO Auto-generated method stub
		return purchaserepo.findByProductCategory(productCategory);
	}

	@Override
	public List<Purchase> findByPurchaseDate(Date purchaseDate) {
		// TODO Auto-generated method stub
		return purchaserepo.findByPurchaseDate(purchaseDate);
	}

}
