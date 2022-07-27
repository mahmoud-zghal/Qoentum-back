package com.sfm.qoentum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sfm.qoentum.entity.Continent;
import com.sfm.qoentum.payload.response.MessageResponse;
import com.sfm.qoentum.repository.ContinentRepository;

@RestController
@RequestMapping("/api/continent")
@ResponseBody
public class ContinentController {
	@Autowired
	ContinentRepository continentRepo;
	
	@PostMapping("/createContinent")
	public Continent createContinent(@RequestBody Continent c){
		continentRepo.save(c);
		return c;
	}
	
	@PutMapping("/updateContinent/{id}")
	public Continent UpdateContinent(@PathVariable ("id") String id,@RequestBody Continent c){
		Continent con=continentRepo.findById(id).orElse(null);
		con.setName(c.getName());
		continentRepo.save(con);
		
		return con;
	}
	
	@GetMapping("/getAllContinent")
	public List<Continent>GetAllContinents(){
		List<Continent>conts= continentRepo.findAll();
		return conts;
		
	}
	
	@DeleteMapping("/deleteContinent/{id}")
	public MessageResponse DeleteContinet(@PathVariable ("id") String id){
		
		continentRepo.deleteById(id);
		if(continentRepo.existsById(id)){
			return new MessageResponse("Error while deleting :id not found");
			
		}else{
			return new MessageResponse("Delete has been successful");
		}

	}
	
	

}
