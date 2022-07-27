package com.sfm.qoentum.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Continents")
public class Continent {
	
	@Id
	private String id;
	
	private String name;

}
