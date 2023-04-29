package com.example.aadar.mapper;

import static java.util.stream.Collectors.toList;
import java.util.List;
import org.springframework.stereotype.Component;
import com.example.aadar.dto.AadharCardCreateRequestDto;
import com.example.aadar.dto.AadharCardResponseDto;
import com.example.aadar.dto.AadharCardUpdateRequestDto;
import com.example.aadar.entity.AadharCardEntity;
import com.example.aadar.entity.Address;

@Component
public class AadharCardMapper {
	public AadharCardEntity toEntity(AadharCardCreateRequestDto createAadharDto) {
		AadharCardEntity aadharCardEntity = new AadharCardEntity();
		Address address = new Address();
		address.setHomeNo(createAadharDto.getHomeNo());
		address.setSocitey(createAadharDto.getSocitey());
		address.setCity(createAadharDto.getCity());
		address.setPincode(createAadharDto.getPincode());
		address.setCountry(createAadharDto.getCountry());
		address.setPlace(createAadharDto.getPlace());
		aadharCardEntity.setFirstName(createAadharDto.getFirstName());
		aadharCardEntity.setLastName(createAadharDto.getLastName());
		aadharCardEntity.setFatherName(createAadharDto.getFatherName());
		aadharCardEntity.setGender(createAadharDto.getGender());
		aadharCardEntity.setPhoneNo(createAadharDto.getPhoneNo());
		aadharCardEntity.setStatus(createAadharDto.getStatus());
		aadharCardEntity.setDateOfBirth(createAadharDto.getDateOfBirth());
		aadharCardEntity.setAddress(address);
		return aadharCardEntity;
	}

	public List<AadharCardResponseDto> toDtoList(List<AadharCardEntity> aadharCardEntityList) {
//    	List<AadharCardResponseDto> aadharCardsResponseDtoList = new ArrayList<>();
//    	for(AadharCardEntity aadharCardEntity : aadharCardsEntity) {
//    		AadharCardResponseDto aadharCardResponseDto = this.toDto(aadharCardEntity);
//    		aadharCardsResponseDtoList.add(aadharCardResponseDto);
//    	}
		return aadharCardEntityList.stream()
				.map(aahdharCardEntity -> this.toDto(aahdharCardEntity)).collect(toList());

	}

	public AadharCardResponseDto toDto(AadharCardEntity aadharCarEntity) {
		AadharCardResponseDto aadharCardResponseDto = new AadharCardResponseDto();
		aadharCardResponseDto.setAadharId(aadharCarEntity.getAadharId());
		aadharCardResponseDto.setFirstName(aadharCarEntity.getFirstName());
		aadharCardResponseDto.setLastName(aadharCarEntity.getLastName());
		aadharCardResponseDto.setFatherName(aadharCarEntity.getFatherName());
		aadharCardResponseDto.setGender(aadharCarEntity.getGender());
		aadharCardResponseDto.setStatus(aadharCarEntity.getStatus());
		aadharCardResponseDto.setPhoneNo(aadharCarEntity.getPhoneNo());
		aadharCardResponseDto.setDateOfBirth(aadharCarEntity.getDateOfBirth());
		aadharCardResponseDto.setCreatedOn(aadharCarEntity.getCreatedOn());
		aadharCardResponseDto.setUpdatedOn(aadharCarEntity.getUpdatedOn());
		if(aadharCarEntity.getAddress()!=null) {
		aadharCardResponseDto.setHomeNo(aadharCarEntity.getAddress().getHomeNo());
		aadharCardResponseDto.setSocitey(aadharCarEntity.getAddress().getSocitey());
		aadharCardResponseDto.setCity(aadharCarEntity.getAddress().getCity());
		aadharCardResponseDto.setPincode(aadharCarEntity.getAddress().getPincode());
		aadharCardResponseDto.setCountry(aadharCarEntity.getAddress().getCountry());
		aadharCardResponseDto.setAddressUpdatedOn(aadharCarEntity.getAddress().getCreatedOn());
		aadharCardResponseDto.setPlace(aadharCarEntity.getAddress().getPlace());
		aadharCardResponseDto.setAddressId(aadharCarEntity.getAddress().getId());
		aadharCardResponseDto.setAddressCreatedOn(aadharCarEntity.getAddress().getCreatedOn());
	}
		return aadharCardResponseDto;
	}

	public AadharCardEntity toEntity(AadharCardUpdateRequestDto aadharCard) {
		Address address = new Address();
		address.setHomeNo(aadharCard.getHomeNo());
		address.setSocitey(aadharCard.getSocitey());
		address.setPlace(aadharCard.getPlace());
		address.setCity(aadharCard.getCity());
		address.setPincode(aadharCard.getPincode());
		address.setCountry(aadharCard.getCountry());
		address.setId(aadharCard.getAddressId());
		address.setCreatedOn(aadharCard.getAddressCreatedOn());
		

		AadharCardEntity aadharCardEntity = new AadharCardEntity();
		aadharCardEntity.setAadharId(aadharCard.getAadharId());
		aadharCardEntity.setFirstName(aadharCard.getFirstName());
		aadharCardEntity.setLastName(aadharCard.getLastName());
		aadharCardEntity.setFatherName(aadharCard.getFatherName());
		aadharCardEntity.setGender(aadharCard.getGender());
		aadharCardEntity.setStatus(aadharCard.getStatus());
		aadharCardEntity.setDateOfBirth(aadharCard.getDateOfBirth());
		aadharCardEntity.setCreatedOn(aadharCard.getCreatedOn());
		aadharCardEntity.setAddress(address);
		aadharCardEntity.setPhoneNo(aadharCard.getPhoneNo());
		
		return aadharCardEntity; 
	}

}
