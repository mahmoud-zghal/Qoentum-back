package com.sfm.qoentum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;


import com.sfm.qoentum.entity.Regions;

public interface RegionsRepository extends MongoRepository<Regions, String> {

}
