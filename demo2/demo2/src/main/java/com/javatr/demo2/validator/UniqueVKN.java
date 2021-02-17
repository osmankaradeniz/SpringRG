package com.javatr.demo2.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {UniqueVknValidator.class})
public @interface UniqueVKN {
	
	String message() default "{demo2.constraint.UniqueVKN.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };
	
}
