package com.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

@Entity
@DynamicUpdate
@Table(name = "PLAYER")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLY_ID")
	private Integer id;
	
	@NonNull
	@Column(name = "PLY_USERNAME", unique = true)
	private String username;
	
	@NonNull
	@Column(name = "PLY_EMAIL", unique = true)
	private String email;
	
	@NonNull
	@Column(name = "PLY_NAME")
	private String name;

	@NonNull
	@Column(name = "PLY_SURNAME")
	private String surname;
	
	@NonNull
	@Column(name = "PLY_BIRTHDAY")
	private Date birthday;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
