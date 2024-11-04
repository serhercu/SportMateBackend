package com.app.service.center;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.center.CenterDTO;
import com.app.model.center.Center;
import com.app.model.center.CenterPlayer;
import com.app.repository.center.CenterImageRepository;
import com.app.repository.center.CenterPlayerRepository;
import com.app.repository.center.CenterRepository;
import com.app.util.ErrorCodes;
import com.app.util.InternalException;

@Service
public class CenterServiceImpl implements ICenterService {

	@Autowired
	private CenterRepository centerRepo;
	
	@Autowired
	private CenterImageRepository centerImageRepo;
	
	@Autowired
	private CenterPlayerRepository centerPlayerRepo;
		
	private CenterDTO mapCenterDTO(Center center) {
		return new CenterDTO(center, centerImageRepo.findByCenter(center));
	}
	
	private CenterDTO returnCenter(Integer centerId) {
		Optional<Center> centerResult = centerRepo.findById(centerId);
		if (centerResult.isPresent()) {
			return mapCenterDTO(centerResult.get());			
		} else {
			throw new InternalException(ErrorCodes.CENTER_NOT_FOUND, "No existe ningún centro para ese id"); 
		}
	}
	
	@Override
	public List<CenterDTO> getCenters(String centerName, Integer cityId, List<Integer> listSports) {
		List<Center> centers = centerRepo.findGamesParameters(centerName, cityId, listSports, 
				listSports == null || listSports.isEmpty() ? 1 : 0);		
		return centers.stream()
                .map(this::mapCenterDTO)
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
	
	@Override
	public CenterDTO followCenter(Integer playerId, Integer centerId) {
		centerPlayerRepo.save(new CenterPlayer(playerId, centerId));
		return returnCenter(centerId);
	}
	@Override
	public CenterDTO unfollowCenter(Integer playerId, Integer centerId) {
		Optional<CenterPlayer> centerPlayerOpt = centerPlayerRepo.findByPlayerAndCenter(playerId, centerId);
		if (centerPlayerOpt.isPresent()) {
			centerPlayerRepo.delete(centerPlayerOpt.get());
			return returnCenter(centerId);
		}
		return null;
	}
}
