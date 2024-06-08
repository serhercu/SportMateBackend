package com.app.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Entity
@DynamicUpdate
@Data
@Table(name = "CENTER")
public class Center {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CNT_ID")
	private Integer id;
	
	@Column(name = "CNT_DESCRIPTION")
	private String description;
	
	@Column(name = "CNT_NAME")
	private String name;
	
	@Column(name = "CNT_LOCATION")
	private String location;
	
	@ManyToMany
	@JoinTable(
	  name = "CENTER_SPORT", 
	  joinColumns = @JoinColumn(name = "CNT_ID"), 
	  inverseJoinColumns = @JoinColumn(name = "SPO_ID"))
	Set<Sport> sports;
	
	@OneToOne
    @JoinColumn(name = "CNT_CITY", referencedColumnName = "CTY_ID")
    private City city;
}
