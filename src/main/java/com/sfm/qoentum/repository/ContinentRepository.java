package com.sfm.qoentum.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sfm.qoentum.entity.Continent;


public interface ContinentRepository extends MongoRepository<Continent, String> {
	Optional<Continent> findByName(String name);
}
