package com.sportyshoes.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Purchase")
@Getter
@Setter
public class Purchase {

	@Id
	@Column(name = "purcahseid", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long purchaseid;
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long purchasebillNo;
	private Date purchaseDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_purchase", joinColumns = {@JoinColumn(name = "productid")},
	inverseJoinColumns = {@JoinColumn(name = "purcahseid")})
	private List<Products> products = new ArrayList<>();
	
	
	private int ordQty;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_purchase", joinColumns = {@JoinColumn(name = "custid")},
	inverseJoinColumns = {@JoinColumn(name = "purcahseid")})
	private List<User> users = new ArrayList<>();

	public long getPurcahseid() {
		return getPurcahseid();
	}

	public void setPurcahseid(long purcahseid) {
		this.purchaseid = purcahseid;
	}

	public long getPurcahsebillNo() {
		return getPurcahsebillNo();
	}

	public void setPurcahsebillNo(long purcahsebillNo) {
		this.purchasebillNo = purcahsebillNo;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	public int getOrdQty() {
		return ordQty;
	}

	public void setOrdQty(int ordQty) {
		this.ordQty = ordQty;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	}
