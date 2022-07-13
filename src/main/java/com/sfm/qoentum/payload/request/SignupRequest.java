package com.sfm.qoentum.payload.request;

import java.util.Set;

import javax.validation.constraints.Email;

import com.sfm.qoentum.entity.Role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignupRequest {
	
    private String username;
 
    
    @Email
    private String email;
    
    private Set<Role> roles;
    
    
    private String password;

}
