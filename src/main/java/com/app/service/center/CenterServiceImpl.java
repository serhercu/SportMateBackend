package com.app.service.center;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.center.CenterDTO;
import com.app.model.center.Center;
import com.app.repository.center.CenterImageRepository;
import com.app.repository.center.CenterRepository;
import com.app.util.ErrorCodes;
import com.app.util.InternalException;

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
                .map(center -> mapCenterDTO(center))
                .collect(Collectors.toList());
	}

	@Override
	public CenterDTO getCenter(Integer centerId) {
		Optional<Center> centerOpt = centerRepo.findById(centerId);
		if (centerOpt.isPresent()) {
			return mapCenterDTO(centerOpt.get());
		} else {
			throw new InternalException(ErrorCodes.CENTER_NOT_FOUND, "No existe ningún centro para ese id"); 

		}
	}
	
	private CenterDTO mapCenterDTO(Center center) {
		return new CenterDTO(center, centerImageRepo.findByCenter(center));
	}
}
