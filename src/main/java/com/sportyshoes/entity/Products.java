package com.sportyshoes.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long productid;
	@Column(nullable = false )
	private String productName;
//image can given an url
//	@lob --> large object to database annotation
//    @Column(name = "IMAGE")
//    private byte[] image;
	@Column(nullable = false )
	private double productprice;
	private String productcategory;
	private String productbrand;
	
	
	public Products() {
		
	}
	public Products(long productid, String productName, double productprice, String productcategory,
			String productbrand) {
		super();
		this.productid = productid;
		this.productName = productName;
		this.productprice = productprice;
		this.productcategory = productcategory;
		this.productbrand = productbrand;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductprice() {
		return productprice;
	}
	public void setProductprice(double productprice) {
		this.productprice = productprice;
	}
	public String getProductcategory() {
		return productcategory;
	}
	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}
	public String getProductbrand() {
		return productbrand;
	}
	public void setProductbrand(String productbrand) {
		this.productbrand = productbrand;
	}
	
}
