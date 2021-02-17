package com.javatr.demo2.model;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {

	@Id
	@Column(name ="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "owner_id")
    private long ownerId;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "vkn",unique = true)
    private String vkn;
    
    @Column(name = "party_name")
    private String partyName;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "middle_name")
    private String middleName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "gb")
    private String gb;
    
    @Column(name = "pk")
    private String pk;
    
    @Column(name = "credit")
    private long credit;
    
    @Column(name = "is_user")
    private boolean isUser;
    
    @Column(name = "is_admin")
    private boolean isAdmin;
    
    @Column(name = "is_super_admin")
    private boolean isSuperAdmin;
    
    @Column(name = "confirmed")
    private boolean confirmed;
    
    @Column(name = "code")
    private String code;
    
    @Column(name = "confirmed_at")
    private String confirmedAt;
    
    @Column(name = "created_at")
    private String createdAt;

	public User(long ownerId, String email, String password, String vkn, String partyName, String firstName,
			String middleName, String lastName, String gb, String pk, long credit, boolean isUser, boolean isAdmin,
			boolean isSuperAdmin, boolean confirmed, String code, String confirmedAt, String createdAt) {
		this.ownerId = ownerId;
		this.email = email;
		this.password = password;
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

	public String getName() {
        String middle= middleName!=null ? middleName+ " " : "";
    	return vkn.length()==10 ? this.partyName : this.firstName + " "+ middle + this.lastName;
    }
    
	public void setConfirmedAt(String confirmedAt) {
        if (confirmedAt != null ) {
            this.confirmedAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(confirmedAt);
        } else {
            this.confirmedAt = null;
        }
    }
	
    public void setCreatedAt(Date createdAt) {
        if (createdAt != null ) { 
            this.createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createdAt);
        } else {
            this.createdAt = null;
        }
    }
	
	
}
