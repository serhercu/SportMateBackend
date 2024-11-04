package com.app.model.player;

import java.sql.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.lang.NonNull;

import com.app.model.Sport;

@Entity
@DynamicUpdate
@Table(name = "PLAYER")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PLY_ID")
	private Long id;
	
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
	
	@ManyToMany
    @JoinTable(
        name = "PLAYER_SPORT",
        joinColumns = @JoinColumn(name = "PLS_PLY_ID"),
        inverseJoinColumns = @JoinColumn(name = "PLS_SPO_ID")
    )
    private Set<Sport> sports;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public Set<Sport> getSports() {
		return sports;
	}

	public void setSports(Set<Sport> sports) {
		this.sports = sports;
	}
}
