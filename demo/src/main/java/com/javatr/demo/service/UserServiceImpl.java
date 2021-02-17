package com.javatr.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatr.demo.dto.UserCreateDTO;
import com.javatr.demo.dto.UserUpdateDTO;
import com.javatr.demo.dto.UserViewDTO;
import com.javatr.demo.exception.NotFoundException;
import com.javatr.demo.model.User;
import com.javatr.demo.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public UserViewDTO getUserById(Long id) {
		final User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return UserViewDTO.of(user);
	}

	@Override 
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> getUsers() {
		return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
	}
	
	
	@Override
	@Transactional
	public UserViewDTO CreateUser(UserCreateDTO userCreateDTO) {
	
		final User user = userRepository.save
				(new User(userCreateDTO.getUsername(),userCreateDTO.getFirstName(),userCreateDTO.getLastName()));
		
		return UserViewDTO.of(user);
	}

	
	@Override
	@Transactional
	public UserViewDTO updateUser(Long id, UserUpdateDTO userUpdateDTO) {
		 
		User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
		 
		 user.setFirstName(userUpdateDTO.getFirstName());
		 user.setLastName(userUpdateDTO.getLastName());
		 user.setUsername(userUpdateDTO.getUsername());

		 final User updatedUser = userRepository.save(user);
		 
	   	 return UserViewDTO.of(updatedUser);
	}

	@Override
	@Transactional
	public void deleteUser(Long id) {
		User user = userRepository.findById(id).orElseThrow(()-> new NotFoundException("Not Found Exception"));
		userRepository.deleteById(user.getId());
	}

	
	@Override
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> slice(Pageable pageable) {
		final List<UserViewDTO> users = userRepository.findAll(pageable).stream().map(UserViewDTO::of).collect(Collectors.toList());
		return users;
	}

	
	public boolean existsUserByUsername(String username){
		return userRepository.existsUserByusername(username);
	}
	
	
	

}
