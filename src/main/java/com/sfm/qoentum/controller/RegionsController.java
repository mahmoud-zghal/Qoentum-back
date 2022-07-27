package com.sfm.qoentum.controller;

import java.util.List;

import javax.swing.plaf.synth.Region;

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
import com.sfm.qoentum.entity.Regions;
import com.sfm.qoentum.payload.response.MessageResponse;
import com.sfm.qoentum.repository.RegionsRepository;

@RestController
@RequestMapping("/api/regions")
@ResponseBody
public class RegionsController {
	
	
	@Autowired
	RegionsRepository regionRepo;
	
	@PostMapping("/createRegion")
	public Regions createRegion(@RequestBody Regions r){
		
		regionRepo.save(r);
		return r;
	}
	
	@PutMapping("/updateRegion/{id}")
	public Regions UpdateRegion(@PathVariable ("id") String id,@RequestBody Regions r){
		Regions reg=regionRepo.findById(id).orElse(null);
		reg.setName(r.getName());
		regionRepo.save(reg);
		
		return reg;
	}
	
	@GetMapping("/getAllRegions")
	public List<Regions>getAllRegions(){
		List<Regions>regs= regionRepo.findAll();
		return regs;
		
	}
	
	@DeleteMapping("/deleteRegions/{id}")
	public MessageResponse DeleteRegions(@PathVariable ("id") String id){
		
		regionRepo.deleteById(id);
		if(regionRepo.existsById(id)){
			return new MessageResponse("Error while deleting :id not found");
			
		}else{
			return new MessageResponse("Delete has been successful");
		}

	}
	
	

	}
