package com.brown.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String firstname;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String lastname;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String email;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String password;

}
