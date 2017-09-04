package com.lifeintokyo.cds.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.lifeintokyo.cds.utils.DateFormatter;

@Controller
public class BuzDateController {
	@Autowired
	private SettingsForm settingsForm;
	
	@PostMapping(value = "/buzzdate/change")
	public String change(@ModelAttribute("buzselect") String date, Model model) {
		DateFormatter.parse(date);
		settingsForm.setBuzDate(date);
		settingsForm.setBuzdateSeldates(DateFormatter.populateBuzdateseldates(date));
		model.addAttribute("msginfo", "業務年月が変更されました。");
		return "fragments/message::buz-info-success";
	}
}
