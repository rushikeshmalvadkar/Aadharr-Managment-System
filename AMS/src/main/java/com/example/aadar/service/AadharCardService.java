package com.example.aadar.service;

import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.aadar.dto.AadharCardCreateRequestDto;
import com.example.aadar.dto.AadharCardResponseDto;
import com.example.aadar.dto.AadharCardUpdateRequestDto;
import com.example.aadar.enam.Status;
import com.example.aadar.entity.AadharCardEntity;
import com.example.aadar.excaption.AadharCardNotFoundExcaption;
import com.example.aadar.mapper.AadharCardMapper;
import com.example.aadar.repository.AadharCardRepositry;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AadharCardService {
      private static final  String MESSAGE ="aadhar is not availabele for this id  ";
	
	private final AadharCardMapper aadharCardMapper;

	
	private final AadharCardRepositry aadharCardRepositry;

	@Transactional
	public String createAadharCard(AadharCardCreateRequestDto createAadharDto) {
		log.info("in my service method ");
		AadharCardEntity entity = this.aadharCardMapper.toEntity(createAadharDto);
		AadharCardEntity savedEntity = this.aadharCardRepositry.save(entity);
		return savedEntity.getAadharId();

	}

	public List<AadharCardResponseDto> getAllAadharCard() {
		List<AadharCardEntity> aadharCardList = this.aadharCardRepositry.findAll();
		return this.aadharCardMapper.toDtoList(aadharCardList);
	}

	public AadharCardResponseDto getAadharCardByAadharId(String aadharId) {
		Optional<AadharCardEntity> aadharCardEntityOptional = this.aadharCardRepositry.findById(aadharId);
		if (aadharCardEntityOptional.isPresent()) {
			AadharCardEntity aadharCardEntity = aadharCardEntityOptional.get();
			return this.aadharCardMapper.toDto(aadharCardEntity);
		} else {
			throw new AadharCardNotFoundExcaption(AadharCardService.MESSAGE + aadharId);
		}
	}

	@Transactional
	public AadharCardResponseDto updateAadharCard(AadharCardUpdateRequestDto aadharCard) {
		AadharCardEntity aadharCardEntity = this.aadharCardMapper.toEntity(aadharCard);
		AadharCardEntity savedAadhar = this.aadharCardRepositry.save(aadharCardEntity);
		AadharCardResponseDto updatedAadharDto = this.aadharCardMapper.toDto(savedAadhar);
		return updatedAadharDto;
	}

	@Transactional
	public Boolean deleteAadharCardByAadharId(String aadharId) {
		Optional<AadharCardEntity> optAadhar = this.aadharCardRepositry.findById(aadharId);
		if (optAadhar.isPresent()) {
			AadharCardEntity aadharCardEntity = optAadhar.get();
			aadharCardEntity.setStatus(Status.DACTIVE);
			AadharCardEntity save = this.aadharCardRepositry.save(aadharCardEntity);
			return true;
		} else {
			throw new AadharCardNotFoundExcaption( AadharCardService.MESSAGE+ aadharId);
		}

	}

}
