package com.sfm.qoentum.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "users")
public class User {
	@Id
	private String id;
	
	private String name;
	private String username;
	private String email;
	private String password;
	private String token;
	
	@DBRef
	  private Set<Role> roles;
	
	
	

	

}
