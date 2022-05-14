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
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private long productid;
	@Column(nullable = false )
	private String productName;
//image can given an url
//	@lob --> large object to database annotation
//    @Column(name = "IMAGE")
//    private byte[] image;
	
	private double productprice;
	private String productcategory;
	private String productbrand;
}
