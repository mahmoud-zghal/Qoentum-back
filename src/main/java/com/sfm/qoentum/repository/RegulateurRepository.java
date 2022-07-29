package com.sfm.qoentum.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.sfm.qoentum.entity.Regulateur;

public interface RegulateurRepository extends MongoRepository<Regulateur, String> {
	Optional<Regulateur> findByName(String name);

}
