package com.javatr.demo.dto.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = {UniqueUserNameValidator.class})
public @interface UniqueUserName {
	
	String message() default "{demo.constraints.username.UniqueUserName.message}";

	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
