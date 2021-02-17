package com.javatr.demo3.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatr.demo3.dto.UserCreateDTO;
import com.javatr.demo3.dto.UserUpdateDTO;
import com.javatr.demo3.dto.UserViewDTO;
import com.javatr.demo3.exception.NotFoundException;
import com.javatr.demo3.model.User;
import com.javatr.demo3.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImp implements UserService {

	private final UserRepository userRepository;

	// tüm kullanıcıları getirme işi
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<UserViewDTO> getUsers() {
		return userRepository.findAll().stream().map(UserViewDTO::of).collect(Collectors.toList());
	}

	// belirli kullanıcıları getirme işi
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public UserViewDTO getUser(long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		return UserViewDTO.of(user);
	}

	// kullanıcı oluşturma işi
	@Override
	@Transactional
	public void createUser(UserCreateDTO userCrateDTO) {

		userRepository.save(
				new User(
				1,userCrateDTO.getEmail(), userCrateDTO.getPassword(),
				userCrateDTO.getVkn(), userCrateDTO.getPartyName(),
				userCrateDTO.getFirstName(),userCrateDTO.getMiddleName(), 
				userCrateDTO.getLastName(),"","",0,true,false,false,false,"",null,
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date()).toString() ));
				
	}
	
	
	// kullanıcı güncelleme işi
	@Override
	@Transactional
	public void updateUser(long id, UserUpdateDTO userUpdateDTO) {

		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		
		user.setEmail(userUpdateDTO.getEmail());
		user.setPartyName(userUpdateDTO.getPartyName());
		user.setFirstName(userUpdateDTO.getFirstName());
		user.setMiddleName(userUpdateDTO.getMiddleName());
		user.setLastName(userUpdateDTO.getLastName());

		userRepository.save(user);
	}

	
	// kullanıcı silme işi
	@Override
	@Transactional
	public void deleteUser(long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));
		userRepository.deleteById(user.getId());
	}

	
	// kullanıcı vkn değeri benzersizlik sorgulama işi
	@Override
	public boolean existsUserByVkn(String vkn) {
		return userRepository.existsUserByVkn(vkn);
	}
	


}
