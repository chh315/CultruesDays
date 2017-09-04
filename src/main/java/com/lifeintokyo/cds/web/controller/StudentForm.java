package com.lifeintokyo.cds.web.controller;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.lifeintokyo.cds.web.validator.CheckDateFormat;
import com.lifeintokyo.cds.web.validator.ValidateDateRange;
import com.lifeintokyo.cds.web.validator.ValidateDateRanges;

import lombok.Data;

@Data
@ValidateDateRanges(value = { @ValidateDateRange(start = "sbsstartdate", end = "sbsenddate", message="サービス終了日はサービス開始日以降の日付を入力してください。"),
		@ValidateDateRange(start = "kykdate", end = "kykenddate", message="契約終了日は契約日以降の日付を入力してください。") })
public class StudentForm {
	private Long id;
	@NotEmpty
	private String hgshname;
	@NotEmpty
	private String hgshkana;
	@NotEmpty
	@Size(min=10, max=10)
	private String jyukyusno;
	@NotEmpty
	private String skschson;
	@NotEmpty
	private String name;
	@NotEmpty
	private String kana;
	private String sgjtype;
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	private String sbsstartdate;
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	private String sbsenddate;
	@NotEmpty
	@Min(0)
	@Max(99)
	private String kykrno;
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	private String kykdate;
	@CheckDateFormat(pattern = "yyyy-MM-dd")
	private String kykenddate;
	@NotEmpty
	@Min(0)
	@Max(31)
	private String kykskryo;
	
	public boolean isNew() {
        return (this.id == null);
    }	
}
