package com.sportyshoes.entity;

import java.util.HashSet;
import java.util.Set;

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
@Table(name = "customer")
@Getter
@Setter

public class Customer {
	
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long custid;
		private String first_name;
		private String last_name;
		@Column(unique = true)
		private String email;
		private String password;
		private String enabled;
		
		
}
