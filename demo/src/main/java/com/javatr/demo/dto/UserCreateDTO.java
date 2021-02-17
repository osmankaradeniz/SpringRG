package com.javatr.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.javatr.demo.dto.validator.UniqueUserName;

import lombok.Data;

@Data
public class UserCreateDTO {
	
	//Db içerisine kaydedilecek verilerin konfigrasyonu için
	//servis ve api katmanının sağlıklı haberleşmesi için
	//javax validation bak.
	
	@NotNull(message = "{demo.constraints.username.NotNull.message}")
	@Size(min=4 ,max=24,message="{demo.constraints.username.Size.message}")
	@UniqueUserName
	private String username;
	
	
	@NotNull(message = "{demo.constraints.firstname.NotNull.message}")
	@Size(min=2 ,max=32,message="{demo.constraints.firstname.Size.message}")
	private String firstName;
	
	@NotNull(message = "{demo.constraints.lastname.NotNull.message}")
	@Size(min=2 ,max=32,message="{demo.constraints.lastname.Size.message}")
	private String lastName;
	
}
