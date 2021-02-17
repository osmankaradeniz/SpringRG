package com.javatr.demo2.service;

import java.util.List;

import com.javatr.demo2.dto.UserCreateDTO;
import com.javatr.demo2.dto.UserUpdateDTO;
import com.javatr.demo2.dto.UserViewDTO;

public interface UserService {

	List<UserViewDTO> getUsers();

	UserViewDTO getUser(long id);

	void createUser(UserCreateDTO userCrateDTO);

	void updateUser(long id, UserUpdateDTO userUpdateDTO);

	void deleteUser(long id);

	boolean existsUserByVkn(String vkn);
}
