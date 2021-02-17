package com.javatr.demo2.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.javatr.demo2.validator.UniqueVKN;

import lombok.Data;

@Data
public class UserCreateDTO {
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private long ownerId;
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
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String gb;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String pk;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private long credit;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private boolean isUser;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private boolean isAdmin;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private boolean isSuperAdmin;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private boolean confirmed;
	
    private String code;
    
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String confirmedAt;
	@NotNull(message = "{demo2.constraints.Notnull.message}")
    private String createdAt;
	
    
    

}
