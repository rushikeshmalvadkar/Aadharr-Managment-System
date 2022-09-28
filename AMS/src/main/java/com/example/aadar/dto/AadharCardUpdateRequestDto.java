package com.example.aadar.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.example.aadar.enam.Gender;
import com.example.aadar.enam.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AadharCardUpdateRequestDto {
	
	@NotEmpty(message="aadhar id is not be null or empaty")
    private String aadharId;
	
	@NotEmpty(message="firstname is not be null or empaty")
    private String firstName;
	
	@NotEmpty(message="lastname is not be null or empaty")
	private String lastName;
	
	@NotEmpty(message = "father is not be null or empaty")
	private String fatherName;
	
	@NotNull(message="gender is not be null or empaty")
	private Gender gender;
	
	@NotEmpty(message="phoneNo is not be null or empaty")
	private String phoneNo;
	
	@NotNull(message="status is not be null or empaty")
	private Status status;
	
	@NotNull
	private LocalDate dateOfBirth;
	@NotNull
	private int homeNo;
	
	@NotEmpty(message="socity should not be null or empaty")
	private String socitey;
	
	@NotEmpty(message="place should not be null or empaty")
	private String place;
	
	@NotNull
	private int pincode;
	
	@NotEmpty(message="city should not be null or empaty")
	private String city;
	
	@NotEmpty(message="country should not be null or empaty")
	private String country;
	
	@NotNull
	private LocalDateTime createdOn;
	
	@NotNull
	private Integer addressId;
	
	private LocalDateTime addressCreatedOn;

}
