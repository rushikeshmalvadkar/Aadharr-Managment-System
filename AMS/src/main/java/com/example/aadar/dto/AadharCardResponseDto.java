package com.example.aadar.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import com.example.aadar.enam.Gender;
import com.example.aadar.enam.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AadharCardResponseDto {
    
	private String aadharId;
	private String firstName;
	private String lastName;
	private String fatherName;
	private Gender gender;
	private String phoneNo;
	private Status status;
	private LocalDate dateOfBirth;
	private LocalDateTime createdOn;
	private LocalDateTime updatedOn;
	private int homeNo;
	private String socitey;
	private String place;
	private int pincode;
	private String city;
	private String country;
	private LocalDateTime addressUpdatedOn;
	private Integer addressId;
	private LocalDateTime addressCreatedOn;
    
	
	
}
