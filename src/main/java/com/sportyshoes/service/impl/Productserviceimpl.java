package com.sportyshoes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportyshoes.entity.Products;
import com.sportyshoes.repository.ProductRepo;
import com.sportyshoes.service.ProductService;

@Service
@Transactional
public class Productserviceimpl implements ProductService {

	@Autowired
	private ProductRepo productrepo;
	
	
	@Override
	public Products createProduct(Products products) {
		// TODO Auto-generated method stub
		return productrepo.save(products);
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productrepo.findAll();
	}

	@Override
	public void deleteByProductId(long productid) {
		// TODO Auto-generated method stub
		productrepo.deleteByProductId(productid);
	}


	@Override
	public Products updateProduct(Products products) {
		// TODO Auto-generated method stub
		return productrepo.save(products);
	}

	@Override
	public List<Products> findByProductCategory(String productcategory) {
		// TODO Auto-generated method stub
		return productrepo.findByProductCategory(productcategory);
	}

	@Override
	public Products findByProductId(long productid) {
		// TODO Auto-generated method stub
		return productrepo.findByProductId(productid);
	}

}
