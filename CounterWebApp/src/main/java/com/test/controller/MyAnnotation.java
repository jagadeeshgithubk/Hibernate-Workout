package com.test.controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Date;

/**
 * TEST driven.
 */
@Target(value=ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	
	WrittenTime writtenTime() default WrittenTime.DEFAULT_DATE;
	
	public enum WrittenTime{
		START_DATE(new Date()),
		DEFAULT_DATE(new Date());
		Date date;
		private WrittenTime(Date date) {
			this.date = date;
		}
	}
	
	String value();
}
