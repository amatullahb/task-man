package com.brown.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project")
public class Project {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String name;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String description;
	
	@OneToMany(targetEntity=Task.class, fetch=FetchType.LAZY)
	@Getter
	private List<Task> tasks;
	
	@OneToOne(targetEntity=Team.class, fetch=FetchType.LAZY)
	@Getter
	@Setter
	private Team team;
	
	@Column(nullable=false)
	@Getter
	@Setter
	private String status;
	
	public void addTask (Task task) {
		tasks.add(task);
	}
	
	public void removeTask (Task task) {
		tasks.remove(task);
	}
}
