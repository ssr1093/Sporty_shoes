package com.sportyshoes.service;

import java.util.List;

import com.sportyshoes.entity.Products;

public interface ProductService {

	public Products createProduct(Products products);
	public List<Products> getAllProducts();
	public void deleteByProductId(int productId);
	public Products findByProductId(int productId);
	public Products updateProduct(Products product);
	public List<Products> findByProductCategory(String productCategory);
}
