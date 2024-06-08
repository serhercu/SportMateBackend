package com.app.service.center;

import java.util.List;

import com.app.model.Center;

public interface ICenterService {
	
	List<Center> getCenters(String centerName, Integer cityId, List<Integer> listSports);
}
