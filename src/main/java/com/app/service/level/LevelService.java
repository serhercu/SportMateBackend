package com.app.service.level;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.LevelDTO;
import com.app.model.Level;
import com.app.repository.LevelRepository;

@Service
public class LevelService implements ILevelService {
	
	@Autowired
	LevelRepository levelRepo;
	
	@Override
	public List<LevelDTO> getAllLevels() {
		
		List<LevelDTO> levelDtoList = new ArrayList<>();
		List<Level> levels = levelRepo.findAll();
		
		for (Level level : levels) {
			LevelDTO levelDto = Level.createDTO(level);
			levelDtoList.add(levelDto);
		}
		return levelDtoList;
	}

}
