package com.app.service.center;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Center;
import com.app.repository.CenterRepository;

@Service
public class CenterServiceImpl implements ICenterService {

	@Autowired
	private CenterRepository centerRepo;
	
	@Override
	public List<Center> getCenters(String centerName, Integer cityId, List<Integer> listSports) {
		return centerRepo.findGamesParameters(listSports);
	}

}
