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

import org.apache.el.parser.AstFalse;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Purchase")
@Getter
@Setter
public class Purchase {

	@Id
	@Column(name = "purcahseid", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO.IDENTITY)
	private long purcahseid;
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long purcahsebillNo;
	private Date purchaseDate;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "product_purchase", joinColumns = {@JoinColumn(name = "pid")},
	inverseJoinColumns = {@JoinColumn(name = "ordID")})
	private List<Products> products = new ArrayList<>();
	
	
	private int ordQty;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "user_purchase", joinColumns = {@JoinColumn(name = "custid")},
	inverseJoinColumns = {@JoinColumn(name = "ordID")})
	private List<User> users = new ArrayList<>();
	
	
	}
