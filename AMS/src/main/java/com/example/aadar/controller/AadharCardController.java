package com.example.aadar.controller;

import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aadar.dto.AadharCardCreateRequestDto;
import com.example.aadar.dto.AadharCardResponseDto;
import com.example.aadar.dto.AadharCardUpdateRequestDto;
import com.example.aadar.response.AadharCardResponseBody;
import com.example.aadar.service.AadharCardService;

import lombok.extern.slf4j.Slf4j;

/**
 * this class responsible for get the http request
 * 
 * @author RUSHIKESH MALVADKAR
 *
 */
@RestController
@RequestMapping("/api/aadhar")
@Slf4j
public class AadharCardController {

	@Autowired
	private AadharCardService aadharCardService;

	@PostMapping("/cards")
	public AadharCardResponseBody<AadharCardCreateRequestDto> createAadharCard(
			@Valid @RequestBody AadharCardCreateRequestDto createAadharDto) {
		log.debug("<<<<< createAadharCard()");
		AadharCardCreateRequestDto createAadharDto1 = this.aadharCardService.createAadharCard(createAadharDto);
		log.debug("createAadharCard() >>>>>>");
		return new AadharCardResponseBody<>(createAadharDto1, HttpStatus.CREATED.value());

	}

	@GetMapping("/cards")
	public AadharCardResponseBody<List<AadharCardResponseDto>> getAllAadharCard() {
		List<AadharCardResponseDto> allAadharCard = this.aadharCardService.getAllAadharCard();
		return new AadharCardResponseBody<>(allAadharCard, HttpStatus.OK.value());
	}

	@GetMapping("/cards/{id}")
	public AadharCardResponseBody<AadharCardResponseDto> getAadharCardByAadharId(@PathVariable("id") String aadharId) {
		AadharCardResponseDto aadharCardResponseDto = this.aadharCardService.getAadharCardByAadharId(aadharId);

		return new AadharCardResponseBody<>(aadharCardResponseDto, HttpStatus.OK.value());
	}

	@PutMapping("/cards")
	public AadharCardResponseBody<AadharCardUpdateRequestDto> updateAadharCard(
			@Valid @RequestBody AadharCardUpdateRequestDto aadharCard) {
		AadharCardUpdateRequestDto aadharCardUpdateRequestDto = this.aadharCardService.updateAadharCard(aadharCard);
		return new AadharCardResponseBody<>(aadharCardUpdateRequestDto, HttpStatus.OK.value());
	}

	@DeleteMapping("/cards/{id}")
	public AadharCardResponseBody<Boolean> deleteAadharCardByAadharId(@PathVariable("id") String aadharId) {
		Boolean isDeleted = this.aadharCardService.deleteAadharCardByAadharId(aadharId);
		return new AadharCardResponseBody<>(isDeleted, HttpStatus.OK.value());
	}
}
