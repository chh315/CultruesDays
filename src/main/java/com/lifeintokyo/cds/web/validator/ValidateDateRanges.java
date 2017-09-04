package com.lifeintokyo.cds.web.validator;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target( { TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface ValidateDateRanges {
	ValidateDateRange[] value();
}