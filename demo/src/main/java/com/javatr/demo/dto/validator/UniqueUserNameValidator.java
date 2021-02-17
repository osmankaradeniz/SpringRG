package com.javatr.demo.dto.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.javatr.demo.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public final class UniqueUserNameValidator implements ConstraintValidator<UniqueUserName, String> {

	private final UserService userService;
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		return !userService.existsUserByUsername(username);
	}

}
