package com.brown.model;

import java.util.Objects;

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

    @Override
    public int hashCode() {
        return Objects.hash(email, firstname, id, lastname, password);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(email, other.email) && Objects.equals(firstname, other.firstname)
                && Objects.equals(id, other.id) && Objects.equals(lastname, other.lastname)
                && Objects.equals(password, other.password);
    }
	
}
