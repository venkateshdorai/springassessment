package com.paintcolour.springassessment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.paintcolour.springassessment.model.Color;

@Repository
public interface ColorRepository extends JpaRepository<Color, String>{
	
	Color findColorByName(String colorName);

}
