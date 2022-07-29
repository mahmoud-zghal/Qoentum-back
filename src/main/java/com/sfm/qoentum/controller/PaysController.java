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
import com.sfm.qoentum.entity.Pays;
import com.sfm.qoentum.entity.Regions;
import com.sfm.qoentum.entity.User;
import com.sfm.qoentum.payload.response.MessageResponse;
import com.sfm.qoentum.repository.ContinentRepository;
import com.sfm.qoentum.repository.PaysRepository;
import com.sfm.qoentum.repository.RegionsRepository;

@RestController
@RequestMapping("/api/pays")
@ResponseBody
public class PaysController {
	
	@Autowired
	PaysRepository paysRepo;
	
	@Autowired
	RegionsRepository regionRepo;
	
	
	@PostMapping("/createPays")
	public Pays createPays(@RequestBody Pays p){
		
		Regions r=regionRepo.findByName(p.getRegion().getName()).orElse(null);
		p.setRegion(r);
		paysRepo.save(p);
		return p;
	}
	
	@PutMapping("/updatePays/{id}")
	public Pays UpdatePays(@PathVariable ("id") String id,@RequestBody Pays p){
		Regions r=regionRepo.findByName(p.getRegion().getName()).orElse(null);
		p.setRegion(r);
		Pays reg=paysRepo.findById(id).orElse(null);
		reg.setName(p.getName());
		reg.setRegion(r);
		paysRepo.save(reg);
		
		return reg;
	}
	
	@GetMapping("/getAllPays")
	public List<Pays>getAllPays(){
		List<Pays>regs= paysRepo.findAll();
		return regs;
		
	}
	
	@DeleteMapping("/deletePays/{id}")
	public MessageResponse DeletePays(@PathVariable ("id") String id){
		
		
		if(paysRepo.existsById(id)){
			paysRepo.deleteById(id);
			return new MessageResponse("Delete has been successful");
			
			
		}else{
			return new MessageResponse("Error while deleting :id not found");
		}

	}

}
