package com.sportyshoes.repository;

import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sportyshoes.entity.Products;
import com.sportyshoes.entity.Purchase;

@Repository
public interface Purchaserepo extends JpaRepository<Purchase, Long> {

	public Purchase findByPurchaseid(long purchaseId);
	public List<Purchase> findByPurchaseDate(Date purchaseDate);
	@Query(value="select * from Purchase WHERE products.productcategory= :productcategory", nativeQuery = true)
	public List<Products> findByProductcategory(@Param("productcategory") String productcategory);

}