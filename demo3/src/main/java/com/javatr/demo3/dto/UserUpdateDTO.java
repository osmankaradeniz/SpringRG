package com.javatr.demo3.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


import lombok.Data;

@Data
public class UserUpdateDTO {
		
		@NotNull(message = "{demo2.constraints.Notnull.message}")
	    private long ownerId;
		@NotNull(message = "{demo2.constraints.Notnull.message}")
	    private String email;
		
		@Size(min=6)
	    private String password;
		
	    private String partyName;
	    private String firstName;
	    private String middleName;
	    private String lastName;
	    
		
	    private String gb;
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
	    private String confirmedAt;
	    
}
