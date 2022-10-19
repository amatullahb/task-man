package com.brown.model;

import java.util.List;
import java.util.Objects;

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
	
	@Override
    public int hashCode() {
        return Objects.hash(description, id, name, status, tasks, team);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Project other = (Project) obj;
        return Objects.equals(description, other.description) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name) && Objects.equals(status, other.status)
                && Objects.equals(tasks, other.tasks) && Objects.equals(team, other.team);
    }
}
