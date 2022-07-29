package com.sfm.qoentum.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.sfm.qoentum.entity.Regions;

public interface RegionsRepository extends MongoRepository<Regions, String> {
	Optional<Regions> findByName(String name);

}
