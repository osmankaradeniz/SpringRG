package com.javatr.demo3.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javatr.demo3.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueVknValidator implements ConstraintValidator<UniqueVKN, String> {

	private final UserService userService;
	
	@Override
	public boolean isValid(String vkn, ConstraintValidatorContext context) {
		return !userService.existsUserByVkn(vkn);
	}

}
