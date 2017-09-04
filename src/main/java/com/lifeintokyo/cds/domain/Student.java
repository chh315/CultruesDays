package com.lifeintokyo.cds.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date updatedate;
	private String hgshname;
	private String hgshkana;
	private String jyukyusno;
	private String skschson;
	private String name;
	private String kana;
	private String sgjtype;
	private String sbsstartdate;
	private String sbsenddate;
	private String kykrno;
	private String kykdate;
	private String kykenddate;
	private String kykskryo;

	@ManyToOne
	private School school;
	@OneToMany
	private List<CustomValue> customValues;
	@OneToMany
	private List<LimitControl> limitControls;
	
}
