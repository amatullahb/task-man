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
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private int id;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String name;
	
	@Column
	@Getter
	@Setter
	private String description;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String status;
	
	@ManyToMany(targetEntity=User.class, fetch=FetchType.EAGER)
	@Getter
	private List<User> assignedTo;
	
	public void assignToUser (User user) {
		assignedTo.add(user);
	}
	
	public void removeUserFromTask (User user) {
		assignedTo.remove(user);
	}
}
