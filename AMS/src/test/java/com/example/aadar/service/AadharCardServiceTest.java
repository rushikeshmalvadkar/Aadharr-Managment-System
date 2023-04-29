package com.example.aadar.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import com.example.aadar.dto.AadharCardCreateRequestDto;
import com.example.aadar.dto.AadharCardResponseDto;
import com.example.aadar.dto.AadharCardUpdateRequestDto;
import com.example.aadar.entity.AadharCardEntity;
import com.example.aadar.excaption.AadharCardNotFoundExcaption;
import com.example.aadar.mapper.AadharCardMapper;
import com.example.aadar.repository.AadharCardRepositry;

class AadharCardServiceTest {

	@Test
	void createAadharCardTest() {
		AadharCardRepositry aadharCardRepoMock = Mockito.mock(AadharCardRepositry.class);

		// Given
		AadharCardCreateRequestDto aadharCardCreateRequestDto = new AadharCardCreateRequestDto();
		aadharCardCreateRequestDto.setFirstName("rushikesh");
		AadharCardEntity savedEntity = new AadharCardEntity();
		savedEntity.setAadharId("123");

		// when
		Mockito.when(aadharCardRepoMock.save(Mockito.any(AadharCardEntity.class))).thenReturn(savedEntity);

		// then
		AadharCardService aadharCardService = new AadharCardService(new AadharCardMapper(), aadharCardRepoMock);
		String aadharCardId = aadharCardService.createAadharCard(aadharCardCreateRequestDto);
		assertEquals("123", aadharCardId);

	}

	@Test
	void getAllAadharCardTest() {

		AadharCardRepositry aaddharCardmock = Mockito.mock(AadharCardRepositry.class);
		// Givan
		AadharCardEntity aadharCardEntity = new AadharCardEntity();
		aadharCardEntity.setAadharId("123");
		List<AadharCardEntity> aadharList = Arrays.asList(aadharCardEntity);

		// when
		Mockito.when(aaddharCardmock.findAll()).thenReturn(aadharList);

		// then
		AadharCardService aadharCardService = new AadharCardService(new AadharCardMapper(), aaddharCardmock);
		List<AadharCardResponseDto> result = aadharCardService.getAllAadharCard();
		assertEquals(1, result.size());
		assertEquals("123", result.get(0).getAadharId());
	}

	@Test
	void updateAadharCardTest() {
		AadharCardRepositry aadharRepoMock = Mockito.mock(AadharCardRepositry.class);

		// Given
		AadharCardUpdateRequestDto aadharCardCreateRequestDto = new AadharCardUpdateRequestDto();
		aadharCardCreateRequestDto.setFirstName("rushikesh");
		AadharCardEntity aadharCardEntity = new AadharCardEntity();
		aadharCardEntity.setFirstName("rushikesh");

		// when
		Mockito.when(aadharRepoMock.save(Mockito.any(AadharCardEntity.class))).thenReturn(aadharCardEntity);

		// then
		AadharCardService aadharCardService = new AadharCardService(new AadharCardMapper(), aadharRepoMock);
		AadharCardResponseDto updateAadharCard = aadharCardService.updateAadharCard(aadharCardCreateRequestDto);
		assertEquals("rushikesh", updateAadharCard.getFirstName());
	}
    
	@Test
	void getAadharCardByAadharIdTest() {
		AadharCardRepositry aadharCardMock = Mockito.mock(AadharCardRepositry.class);
		//Given
		  AadharCardEntity aadharCardEntity = new AadharCardEntity();
		  aadharCardEntity.setFirstName("abhi");
		  Optional<AadharCardEntity> aadharCardEntityForTest = Optional.ofNullable(aadharCardEntity);
		//when
		Mockito.when(aadharCardMock.findById("123")).thenReturn(aadharCardEntityForTest);
		
		//then
		AadharCardService aadharCardService = new AadharCardService(new AadharCardMapper(), aadharCardMock);
		AadharCardResponseDto aadharCardByAadharId = aadharCardService.getAadharCardByAadharId("123");
		assertEquals("abhi", aadharCardByAadharId.getFirstName());
		
	}
	@Test
   void	getAadharCardByAadharIdTestForNull() {
		AadharCardRepositry aadharCardMock = Mockito.mock(AadharCardRepositry.class);
		
		//Given
		
		//when
		Mockito.when(aadharCardMock.findById("123")).thenReturn(Optional.empty());
		//then
		AadharCardService aadharCardService = new AadharCardService(new AadharCardMapper(), aadharCardMock);
		
		assertThrows(AadharCardNotFoundExcaption.class, ()->aadharCardService.getAadharCardByAadharId("123"));
		
   }
	
	
}

