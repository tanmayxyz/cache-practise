package com.tanmay.entity;

import static javax.persistence.GenerationType.TABLE;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Tree {

	@Id
	@GeneratedValue(strategy = TABLE)
	private Integer id;
	private String name;
	private String scientificName;
}
