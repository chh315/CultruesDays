package com.lifeintokyo.cds.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
	private String 形式番号;
	private String 形式記号;
	private String サービス提供年月;
	private String 法人名;
	private String 代表者;
	private String 事業者名;
	private String 略称;
	@OneToOne
	private Staff 管理者;
	private String 事業者番号;
	private String 郵便番号;
	private String 住所;
	private String 電話番号;
	private String 種別;
	private String 地域区分;
	private String 定員;
	private String 福祉専門職員配置等加算;
	private String 指導員加配加算;
	private String 開所時間減算;
	private String 児童発達支援管理責任者専任加算;
	private String 医療連携看護職員;
	private String 児童指導員等配置加算;
	private String 定員超過;
	private String 従業員欠員;
	private String 処遇改善都道府県;
	private String 処遇改善都道府県番号;
	private String 処遇改善キャリアパス区分;
	private String 処遇改善特別加算;
	@OneToOne
	private Staff 請求書氏名;
	private String 利用者請求書備考;
	
	@OneToMany
	private List<CustomValue> customValues;
	@OneToMany
	private List<Staff> teachers;
	@OneToMany
	private List<Staff> parts;
	@OneToMany
	private List<Student> students;
}
