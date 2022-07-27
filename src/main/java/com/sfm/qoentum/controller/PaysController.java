package com.sfm.qoentum.controller;

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

import com.sfm.qoentum.entity.Pays;
import com.sfm.qoentum.entity.User;
import com.sfm.qoentum.repository.PaysRepository;

@RestController
@RequestMapping("/api/pays")
@ResponseBody
public class PaysController {
	
	@Autowired
	PaysRepository paysRepo;
	
	@PostMapping("/createPays")
	public void createPays(@RequestBody Pays p){
		//Pays pays=new Pays( p.getName(), p.get)
		paysRepo.save(p);
	}
	
	@PutMapping("/updatePays/{id}")
	public void updatePays(@PathVariable("id") String id,@RequestBody Pays pays){
		Pays p=paysRepo.findById(id).orElse(null);
		p.setName(pays.getName());
	}
	@GetMapping("/getPays")
	public void GetPays(){
		paysRepo.findAll();
	}
	
	@DeleteMapping("/deletPays/{id}")
	public void deletPays(@PathVariable("id") String id){
		paysRepo.deleteById(id);
		
	}

}
