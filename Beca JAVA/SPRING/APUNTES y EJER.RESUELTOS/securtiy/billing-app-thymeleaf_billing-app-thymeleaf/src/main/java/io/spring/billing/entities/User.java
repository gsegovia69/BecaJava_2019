package io.spring.billing.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
	
	@Id
	public String username; 
	
	public String password;
	
	@OneToMany
	public Role role; 

}
