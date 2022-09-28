package com.example.aadar.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.example.aadar.enam.Gender;
import com.example.aadar.enam.Status;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AadharCardCreateRequestDto {

	@NotEmpty(message = "firstname should not be null or empaty")
	private String firstName;

	@NotEmpty(message = "lastname should not be null or  empaty")
	private String lastName;

	@NotEmpty(message = "father should not be null and  empaty")
	private String fatherName;

	@NotNull(message = "gender should not be null and empaty")
	private Gender gender;

	@Size(min = 10, max = 10, message = "phone no should be 10 digit")
	private String phoneNo;

	@NotNull(message="status should not be null or empaty ")
	private Status status;
    
	@NotNull
	private LocalDate dateOfBirth;
    
	@NotNull
	private int homeNo;
    
	@NotEmpty(message = "socity should not be null or empaty ")
	private String socitey;
    
	@NotEmpty(message="place should not be null or empaty ")
	private String place;
    
	@NotNull
	private int pincode;
    
	@NotEmpty(message="city should not be null or empaty ")
	private String city;
    
	@NotEmpty(message="country  should not be null or empaty ")
	private String country;

}
