package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
@Table(name = "AUTHENTICATION")
public class Authentication {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATH_ID")
	private Integer id;
	
	@Column(name = "ATH_USER_ID", unique = true)
	private Integer userId;
	
	@Column(name = "ATH_HASH", unique = true)
	private String hash;
	
	public Authentication() {
		
	}
	
	public Authentication(Integer userId, String hash) {
		this.setUserId(userId);
		this.setHash(hash);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
}
