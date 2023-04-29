package com.example.aadar.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import com.example.aadar.enam.Gender;
import com.example.aadar.enam.Status;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


/**
 * this class is responsibale to detail of aadharcard
 * @author ABHISHEK MALVADKAR
 *
 */
@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name="aadhar")
public class AadharCardEntity {
    /**
     * this is aadar id
     */
	@Id
	@Column(name="ID")
	private String aadharId;
	
	/**
	 * This is the aadahr holder name
	 */
	@Column(name="FIRST_NAME")
	private String firstName;
	
	/**
	 * This is lastname
	 */
	@Column(name="LAST_NAME")
	private String lastName;
	
	/**
	 * This is fathername
	 */
	@Column(name="FATHER_NAME")
	private String fatherName;
	
	/**
	 *This is gender
	 */
	@Column(name="GENDER")
	 @Enumerated(EnumType.STRING)
	private Gender gender;
	
	/**
	 * This is phoneNo
	 */
	@Column(name="PHONE_NO")
	private String phoneNo;
	
	/**
	 * This is status
	 */
	@Enumerated(EnumType.STRING)
	@Column(name="STATUS")
	private Status status;
	
	/**
	 * This is repersent the date of birth 
	 */
	@Column(name="DATE_OF_BIRTH")
	private LocalDate dateOfBirth;
	
	/**
	 * This is created date
	 */
	@Column(name="CREATED_ON")
	private LocalDateTime createdOn;
	
	/**
	 * This is update date
	 */
	@Column(name="UPDATED_ON")
	private LocalDateTime updatedOn;
	
	/**
	 * This is address
	 */
	@OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	@JoinColumn(name="ADDRESS_ID")
	private Address address;
     
	/**
	 * this method is set the value id,createdDate and updatedate before
	 * create query
	 */
	@PrePersist
	public void presistRemaingThing() {
		this.aadharId= UUID.randomUUID().toString();
		this.createdOn=LocalDateTime.now();
		this.updatedOn=LocalDateTime.now();
	}
	
	/**
	 * this method responsible for to update date for update opretaion
	 */
	@PreUpdate
	public void beforeUpdate() {
		this.updatedOn=LocalDateTime.now(); 
	}
	
	  
}
