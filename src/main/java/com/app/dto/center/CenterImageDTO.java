package com.app.dto.center;

import java.util.ArrayList;
import java.util.List;

import com.app.model.center.CenterImage;

import lombok.Data;

@Data
public class CenterImageDTO {
	
	private String profile;
	
	private List<String> banner = new ArrayList<>();
	
	public CenterImageDTO(List<CenterImage> images) {
		for (CenterImage centerImg : images) {
			if (centerImg.getType().equalsIgnoreCase(CenterImage.TYPE_PROFILE)) {
				this.profile = centerImg.getPath();
			} else if (centerImg.getType().equalsIgnoreCase(CenterImage.TYPE_BANNER)) {
				this.banner.add(centerImg.getPath());
			}
		}
	}

}
