package com.app.service.province;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Province;
import com.app.repository.ProvinceRepository;

@Service
public class ProvinceService implements IProvinceService {
	
	@Autowired
	ProvinceRepository provinceRepo;
	
	@Override
	public List<Province> getAll() {
		
		return provinceRepo.findAll();
		
	}

}
