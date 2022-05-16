package com.sportyshoes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Products;

@Repository
public interface ProductRepo extends JpaRepository<Products, Long>{
	public void deleteByProductId(long productid); 
	public Products findByProductId(long productid);
	public List<Products> findByProductCategory(String productcategory);
}
