package com.sfm.qoentum.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfm.qoentum.entity.ERole;
import com.sfm.qoentum.entity.Role;
import com.sfm.qoentum.entity.User;
import com.sfm.qoentum.payload.request.SignupRequest;
import com.sfm.qoentum.repository.RoleRepository;
import com.sfm.qoentum.repository.UserRepository;





@RestController
@RequestMapping("/api/user")
@ResponseBody
public class UserController {
	@Autowired
	UserRepository userRepo;
	@Autowired
    private PasswordEncoder passwordEncoder;
	@Autowired
	RoleRepository roleRepository;
	
	/*@PostMapping("/createUser")
	public void createUser(@RequestBody User u){
		//User u=new User( u.getName(), u.getUsername(), u.getEmail(), u.getPassword(), u.getRoles());
		
		userRepo.save(u);
		
	}*/
	
	@PutMapping("/updateUser/{id}")
	public User UpdateUser(@PathVariable("id") String id,@RequestBody User user){
		User u=userRepo.findById(id).orElse(null);
		//user.setId(id);
		//u=user;
		//return u;
		
		//u.setName(user.getName());
		u.setUsername(user.getUsername());
		u.setEmail(user.getEmail());
		//u.setRoles(user.getRoles());
		//u.setPassword(user.getPassword());
		
		
		
		
		/*Role userRole = roleRepository.findByName(ERole.ROLE_USER).orElse(null);
		roles.add(userRole);
		u.setRoles(roles); */
		userRepo.save(u);
		return u;
		
		
		
		
		
		
	}
	@GetMapping("/getUser/{id}")
	  public ResponseEntity<User> getTutorialById(@PathVariable("id") String id) {
	    Optional<User> tutorialData = userRepo.findById(id);

	    
	      return new ResponseEntity<>(( tutorialData).get(), HttpStatus.OK);
	   
	  }
	
	@DeleteMapping("/delUser/{id}")
	public void deleteUser(@PathVariable ("id") String id){
		userRepo.deleteById(id);
	}
	
	@GetMapping("/getAllUsers")
	public List<User> getAllUsers(){
		List<User>users=userRepo.findAll();
		return users;
		
	}
	
	@PutMapping("/updatePassword/{id}")
	public void changepassword(@PathVariable("id") String id,@RequestParam String newPass){
		User u=userRepo.findById(id).orElse(null);
		
		
		u.setPassword(passwordEncoder.encode(newPass));
		userRepo.save(u);
		
	}
	
	
	
	

}
