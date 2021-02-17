package com.javatr.demo2.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javatr.demo2.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueVknValidator implements ConstraintValidator<UniqueVKN, String> {

	private final UserService userService;
	
	@Override
	public boolean isValid(String vkn, ConstraintValidatorContext context) {
		return !userService.existsUserByVkn(vkn);
	}

}
