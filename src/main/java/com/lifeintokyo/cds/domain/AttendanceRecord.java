package com.lifeintokyo.cds.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AttendanceRecord {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date dayofatt;
	private String start;
	private String end;
	private boolean send;
	private boolean pickup;
	private boolean absence;
}
