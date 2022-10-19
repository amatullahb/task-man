package com.brown.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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
@Table(name="task")
public class Task {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Getter
	private Long id;
	
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
	
	@Column
	@Getter
	@Setter
	private boolean urgent;
	
	@Column
	@Getter
	@Setter
	private Date completedOn;
	
	@ManyToMany(targetEntity=User.class, fetch=FetchType.EAGER)
	@Getter
	private List<User> assignedTo;
	
	/**
	 * Method adds a user to the task's assignedTo list. 
	 * This also creates a record in the userstasks table.
	 * @param user
	 */
	public void assignToUser (User user) {
		assignedTo.add(user);
	}
	
	/**
	 * Method removes a user from the task's assignedTo list.
	 * This removes the record associating this user to the task in the usertasks table.s
	 * @param user
	 */
	public void removeUserFromTask (User user) {
		assignedTo.remove(user);
	}

    @Override
    public int hashCode() {
        return Objects.hash(assignedTo, completedOn, description, id, name, status, urgent);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Task other = (Task) obj;
        return Objects.equals(assignedTo, other.assignedTo) && Objects.equals(completedOn, other.completedOn)
                && Objects.equals(description, other.description) && Objects.equals(id, other.id)
                && Objects.equals(name, other.name) && Objects.equals(status, other.status) && urgent == other.urgent;
    }
	
}
