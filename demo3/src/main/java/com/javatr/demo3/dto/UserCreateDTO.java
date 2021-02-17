package com.javatr.demo3.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.javatr.demo3.validator.UniqueVKN;

import lombok.Data;

@Data
public class UserCreateDTO {
	
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String email;
	
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String password;
	
	@NotNull(message = "{demo2.constraints.Notnull.message}")
	@UniqueVKN
	@Size(min = 10,max = 10,message = "{demo2.constraints.vkn.Size.message}")
    private String vkn;
	
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String partyName;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String firstName;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String middleName;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String lastName;
	
}
