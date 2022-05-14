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
	public void deleteByProductId(int productId) {
		// TODO Auto-generated method stub
			productrepo.deleteById(productId);
	}

	@Override
	public Products findByProductId(int productId) {
		// TODO Auto-generated method stub
		return productrepo.findByProductId(productId);
	}

	@Override
	public Products updateProduct(Products product) {
		// TODO Auto-generated method stub
		return productrepo.save(product);
	}

	@Override
	public List<Products> findByProductCategory(String productCategory) {
		// TODO Auto-generated method stub
		return productrepo.findByProductCategory(productCategory);
	}

}
