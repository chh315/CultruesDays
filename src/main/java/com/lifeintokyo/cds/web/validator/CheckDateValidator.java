package com.lifeintokyo.cds.web.validator;

import java.text.SimpleDateFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckDateValidator implements ConstraintValidator<CheckDateFormat, String> {

    private String pattern;

    @Override
    public void initialize(CheckDateFormat constraintAnnotation) {
        this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null || "".equals(object)) {
            return true;
        }

        try {
        	SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        	dateFormat.setLenient(false);
        	dateFormat.parse(object);
            return true;
        } catch (Exception e) {
//            e.printStackTrace();
            return false;
        }
    }
}