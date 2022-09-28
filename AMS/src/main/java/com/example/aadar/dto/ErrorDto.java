package com.example.aadar.dto;

import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ErrorDto {
	
   private List<String> errors;
   private Integer status;
   
   public ErrorDto(List<String> errors,Integer status) {
	   this.errors=errors;
	   this.status=status;
   }
}
