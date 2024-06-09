package com.app.dto.center;

import java.util.List;
import java.util.Set;

import com.app.model.Sport;
import com.app.model.center.Center;
import com.app.model.center.CenterImage;

import lombok.Data;

@Data
public class CenterDTO {
	
	private Integer id;
	private String name;
	private String description;
	private String location;
	private Set<Sport> sports;
	private CenterImageDTO images;
	
	public CenterDTO(Center center, List<CenterImage> images) {
		this.id = center.getId();
		this.name = center.getName();
		this.description = center.getDescription();
		this.location = center.getLocation();
		this.sports = center.getSports();
		this.images = new CenterImageDTO(images);
	}
}
