package com.example.aadar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import com.example.aadar.entity.AadharCardEntity;

public interface AadharCardRepositry extends JpaRepository<AadharCardEntity, String>{

}
