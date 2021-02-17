package com.javatr.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.javatr.demo.dto.UserCreateDTO;
import com.javatr.demo.dto.UserUpdateDTO;
import com.javatr.demo.dto.UserViewDTO;

public interface UserService {
	
	UserViewDTO getUserById(Long id);
	UserViewDTO CreateUser(UserCreateDTO userCreateDTO);
	List<UserViewDTO> getUsers();
	UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO);
	void deleteUser(Long id);
	List<UserViewDTO> slice(Pageable pageable);
	boolean existsUserByUsername(String username);
}
