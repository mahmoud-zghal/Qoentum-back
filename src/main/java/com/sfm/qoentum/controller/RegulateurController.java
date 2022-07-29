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
import com.sfm.qoentum.entity.Regulateur;
import com.sfm.qoentum.payload.response.MessageResponse;
import com.sfm.qoentum.repository.PaysRepository;
import com.sfm.qoentum.repository.RegionsRepository;
import com.sfm.qoentum.repository.RegulateurRepository;

@RestController
@RequestMapping("/api/regulateurs")
@ResponseBody
public class RegulateurController {
	@Autowired
	RegulateurRepository regulateurRepo;
	@Autowired
	PaysRepository paysRepo;
	
	@PostMapping("/createRegulateur")
	public Regulateur createRegulateur(@RequestBody Regulateur r){
		
		Pays p=paysRepo.findByName(r.getPays().getName()).orElse(null);
		r.setPays(p);
		regulateurRepo.save(r);
		return r;
	}
	
	@PutMapping("/updateRegulateur/{id}")
	public Regulateur UpdateRegion(@PathVariable ("id") String id,@RequestBody Regulateur r){
		Pays p=paysRepo.findByName(r.getPays().getName()).orElse(null);
		r.setPays(p);
		Regulateur reg=regulateurRepo.findById(id).orElse(null);
		reg.setName(r.getName());
		reg.setPays(r.getPays());
		regulateurRepo.save(reg);
		
		return reg;
	}
	
	@GetMapping("/getAllRegulateur")
	public List<Regulateur>getAllRegulateurs(){
		List<Regulateur>regs= regulateurRepo.findAll();
		return regs;
		
	}
	
	@DeleteMapping("/deleteRegulateur/{id}")
	public MessageResponse DeleteRegions(@PathVariable ("id") String id){
		
		
		if(regulateurRepo.existsById(id)){
			
			regulateurRepo.deleteById(id);
			return new MessageResponse("Delete has been successful");
		}else{
			return new MessageResponse("Error while deleting :id not found");
		}

	}

}
