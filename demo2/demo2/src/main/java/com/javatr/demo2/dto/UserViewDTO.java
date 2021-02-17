package com.javatr.demo2.dto;

import java.io.Serializable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.javatr.demo2.model.User;

import lombok.Getter;

@Getter
public final class UserViewDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    private long ownerId;
    private String email;
    private String vkn;
    private String partyName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String gb;
    private String pk;
    private long credit;
    private boolean isUser;
    private boolean isAdmin;
    private boolean isSuperAdmin;
    private boolean confirmed;
    private String code;
    private String confirmedAt;
    private String createdAt;
	
    private UserViewDTO(Long id, long ownerId, String email, String vkn, String partyName, String firstName,
			String middleName, String lastName, String gb, String pk, long credit, boolean isUser, boolean isAdmin,
			boolean isSuperAdmin, boolean confirmed, String code, String confirmedAt, String createdAt) {
		this.id = id;
		this.ownerId = ownerId;
		this.email = email;
		this.vkn = vkn;
		this.partyName = partyName;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gb = gb;
		this.pk = pk;
		this.credit = credit;
		this.isUser = isUser;
		this.isAdmin = isAdmin;
		this.isSuperAdmin = isSuperAdmin;
		this.confirmed = confirmed;
		this.code = code;
		this.confirmedAt = confirmedAt;
		this.createdAt = createdAt;
	}
    
    public static UserViewDTO of(User user)
    {
    	return new UserViewDTO(
    			user.getId(),user.getOwnerId(),user.getEmail(),
    			user.getVkn(),user.getPartyName(),user.getFirstName(),
    			user.getMiddleName(),user.getLastName(),user.getGb(),
    			user.getPk(),user.getCredit(),user.isUser(),user.isAdmin(),
    			user.isSuperAdmin(),user.isConfirmed(),user.getCode(),
    			user.getConfirmedAt(),user.getCreatedAt()
    			);
    }
    
    
    
}
