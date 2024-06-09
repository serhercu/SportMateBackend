package com.app.service.center;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.center.CenterDTO;
import com.app.model.center.Center;
import com.app.repository.center.CenterImageRepository;
import com.app.repository.center.CenterRepository;

@Service
public class CenterServiceImpl implements ICenterService {

	@Autowired
	private CenterRepository centerRepo;
	
	@Autowired
	private CenterImageRepository centerImageRepo;
	
	@Override
	public List<CenterDTO> getCenters(String centerName, Integer cityId, List<Integer> listSports) {
		List<Center> centers = centerRepo.findGamesParameters(centerName != null ? centerName : "", cityId, listSports);		
		return centers.stream()
                .map(center -> new CenterDTO(center, centerImageRepo.findByCenter(center)))
                .collect(Collectors.toList());
	}
}
