package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Integer>{
	public void deleteByProductId(int productid); 
	public Products findByProductId(int productid);
	public List<Products> findByProductCategory(String productcategory);
}
