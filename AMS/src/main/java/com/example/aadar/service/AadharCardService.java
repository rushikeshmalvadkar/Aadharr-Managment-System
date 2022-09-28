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

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AadharCardService {
      private static final  String MESSAGE ="aadhar is not availabele for this id  ";
	@Autowired
	private AadharCardMapper aadharCardMapper;

	@Autowired
	private AadharCardRepositry aadharCardRepositry;

	@Transactional
	public AadharCardCreateRequestDto createAadharCard(AadharCardCreateRequestDto createAadharDto) {
		log.info("in my service method ");
		AadharCardEntity entity = this.aadharCardMapper.toEntity(createAadharDto);
		this.aadharCardRepositry.save(entity);
		return createAadharDto;

	}

	public List<AadharCardResponseDto> getAllAadharCard() {
		List<AadharCardEntity> findAll = (List<AadharCardEntity>) this.aadharCardRepositry.findAll();
		return this.aadharCardMapper.toDtoList(findAll);
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
	public AadharCardUpdateRequestDto updateAadharCard(AadharCardUpdateRequestDto aadharCard) {
		AadharCardEntity aadharCardEntity = this.aadharCardMapper.toEntity(aadharCard);
		this.aadharCardRepositry.save(aadharCardEntity);
		return aadharCard;
	}

	@Transactional
	public Boolean deleteAadharCardByAadharId(String aadharId) {
		Optional<AadharCardEntity> optAadhar = this.aadharCardRepositry.findById(aadharId);
		if (optAadhar.isPresent()) {
			AadharCardEntity aadharCardEntity = optAadhar.get();
			aadharCardEntity.setStatus(Status.DACTIVE);
			this.aadharCardRepositry.save(aadharCardEntity);
			return true;
		} else {
			throw new AadharCardNotFoundExcaption( AadharCardService.MESSAGE+ aadharId);
		}

	}

}
