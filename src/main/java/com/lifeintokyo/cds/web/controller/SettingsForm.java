package com.lifeintokyo.cds.web.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import com.lifeintokyo.cds.utils.DateFormatter;

import lombok.Data;

@Data
@SessionScope
@Component
public class SettingsForm {
	private String buzDate = "2018-08-01";
	private Long schoolid = 1L;
	private Map<String, String> buzdateSeldates;
}
