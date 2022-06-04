package com.app.service.sport;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.SportDTO;
import com.app.model.Sport;
import com.app.repository.SportRepository;

@Service
public class SportService implements ISportService {
	
	@Autowired
	SportRepository sportRepo;

	@Override
	public List<SportDTO> getAllSports() {
		List<SportDTO> sportDtoList = new ArrayList<>();
		List<Sport> sportList = sportRepo.findAll();
		
		for (Sport sport : sportList) {
			sportDtoList.add(Sport.createDTO(sport));
		}
		
		return sportDtoList;
	}

}
