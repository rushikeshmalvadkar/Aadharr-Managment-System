package com.example.aadar.entity;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="address")
public class Address {
   
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	
	@Column(name="HOME_NO")
	private int homeNo;
	
	@Column(name="SOCITY")
	private String socitey;
	
	@Column(name="PLACE")
	private String place;
	
	@Column(name="PINCODE")
	private int pincode;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="COUNTRY")
	private String country;
    
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	
	@Column(name="UPDATED_ON")
	private LocalDateTime updateOn;
	
	@PrePersist
	public void presistRemaingThing() {
		this.createdOn=LocalDateTime.now();
		this.updateOn=LocalDateTime.now();
	}
	
	@PreUpdate
	public void beforeUpdate() {
		this.updateOn = LocalDateTime.now();
	}
}
