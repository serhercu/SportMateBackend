package com.app.model.center;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@DynamicUpdate
@Data
@Table(name = "CENTER_IMAGE")
public class CenterImage {
	
	public static final String TYPE_PROFILE = "P";
	public static final String TYPE_BANNER = "B";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CNI_ID")
	private Integer id;
	
	@ManyToOne
    @JoinColumn(name = "CNI_CNT")
    private Center center;
	
	@Column(name = "CNI_PATH")
	private String path;
	
	@Column(name = "CNI_TYPE")
	private String type;
}
