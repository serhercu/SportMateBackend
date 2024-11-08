package com.app.service.center;

import java.util.List;

import com.app.dto.center.CenterDTO;

public interface ICenterService {
	
	List<CenterDTO> getCenters(String centerName, Integer cityId, List<Integer> listSports);
	
	CenterDTO getCenter(Integer centerId);
	
	CenterDTO followCenter(Integer playerId, Integer centerId);
	
	CenterDTO unfollowCenter(Integer playerId, Integer centerId);
}
