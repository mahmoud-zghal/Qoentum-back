package com.sfm.qoentum.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.sfm.qoentum.entity.Pays;

public interface PaysRepository extends MongoRepository<Pays, String>{
	Optional<Pays> findByName(String name);

}
