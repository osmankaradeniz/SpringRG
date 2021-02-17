package com.javatr.demo2.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class UserUpdateDTO {
		
		@NotNull(message = "{demo2.constraints.Notnull.message}")
	    private long ownerId;
		@NotNull(message = "{demo2.constraints.Notnull.message}")
	    private String email;
		
		@NotNull(message = "{demo2.constraints.Notnull.message}")
	    private String password;
		
	    private String partyName;
	    private String firstName;
	    private String middleName;
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
	
}
