package com.lifeintokyo.cds.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
	
import lombok.Data;

@Entity
@Data
public class Activity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private Calendar calendar;
	private String eventName;
	private String start;
	private String end;
//	@OneToMany
//	private List<Staff> managers;
}
