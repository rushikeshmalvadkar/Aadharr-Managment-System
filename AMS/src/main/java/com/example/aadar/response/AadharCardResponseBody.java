package com.example.aadar.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AadharCardResponseBody<T> {
    
	private T data;
	private Integer status;
	
	 
	
}
