package com.lifeintokyo.cds.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class DateRangeValidator implements ConstraintValidator<ValidateDateRange, Object> {
	private String start;
	private String end;

	public void initialize(ValidateDateRange validateDateRange) {
		start = validateDateRange.start();
		end = validateDateRange.end();
	}

	public boolean isValid(Object form, ConstraintValidatorContext constraintValidatorContext) {
		BeanWrapper formBean = new BeanWrapperImpl(form);
		String startDate = formBean.getPropertyValue(start).toString();
		String endDate = formBean.getPropertyValue(end).toString();
		
		if ("".equals(startDate) || "".equals(endDate)) {
			return true;
		}
		
		return startDate.compareTo(endDate) <= 0;
	}

}