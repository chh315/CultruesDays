package com.lifeintokyo.cds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Staff {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Integer cost;
	private Integer costunit;
	private String hiredate;
	@ManyToOne
	private School school;
//	private Integer age;
//	private Integer gender;
//	private String tel;
}
