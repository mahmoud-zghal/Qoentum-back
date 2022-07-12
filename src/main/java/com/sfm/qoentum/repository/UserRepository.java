package com.sfm.qoentum.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sfm.qoentum.entity.User;

public interface UserRepository extends MongoRepository<User, String> {

}
