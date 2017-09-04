package com.lifeintokyo.cds.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class LimitControl {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String 上限額管理後利用者負担額;
	private String 事業所名;
	private String 事業所番号;
	private String 総費用額;
	private String 利用者負担額;
	private String 年月;
	@ManyToOne
	private Student student;
}
