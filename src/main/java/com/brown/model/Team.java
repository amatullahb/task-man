package com.brown.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Team {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private int id;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String description;
	
	@ManyToMany(targetEntity=User.class, fetch=FetchType.EAGER)
	@Getter
	private List<User> members;
	
	public void addMember (User member) {
		members.add(member);
	}
	
	public void removeMember (User member) {
		members.remove(member);
	}

}
