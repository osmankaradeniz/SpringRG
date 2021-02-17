package com.javatr.demo2.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.javatr.demo2.dto.UserCreateDTO;
import com.javatr.demo2.dto.UserUpdateDTO;
import com.javatr.demo2.dto.UserViewDTO;
import com.javatr.demo2.exception.NotFoundException;
import com.javatr.demo2.model.User;
import com.javatr.demo2.repository.UserRepository;

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

		userRepository.save(new User(userCrateDTO.getOwnerId(), userCrateDTO.getEmail(), userCrateDTO.getPassword(),
				userCrateDTO.getVkn(), userCrateDTO.getPartyName(), userCrateDTO.getFirstName(),
				userCrateDTO.getMiddleName(), userCrateDTO.getLastName(), userCrateDTO.getGb(), userCrateDTO.getPk(),
				userCrateDTO.getCredit(), userCrateDTO.isUser(), userCrateDTO.isAdmin(), userCrateDTO.isSuperAdmin(),
				userCrateDTO.isConfirmed(), userCrateDTO.getCode(), userCrateDTO.getConfirmedAt(),
				userCrateDTO.getCreatedAt()));
	}
	
	
	// kullanıcı güncelleme işi
	@Override
	@Transactional
	public void updateUser(long id, UserUpdateDTO userUpdateDTO) {

		User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not Found Exception"));

		user.setOwnerId(userUpdateDTO.getOwnerId());
		user.setEmail(userUpdateDTO.getEmail());
		user.setPassword(userUpdateDTO.getPassword());
		user.setPartyName(userUpdateDTO.getPartyName());
		user.setFirstName(userUpdateDTO.getFirstName());
		user.setMiddleName(userUpdateDTO.getMiddleName());
		user.setLastName(userUpdateDTO.getLastName());
		user.setGb(userUpdateDTO.getGb());
		user.setPk(userUpdateDTO.getPk());
		user.setCredit(userUpdateDTO.getCredit());
		user.setUser(userUpdateDTO.isUser());
		user.setAdmin(userUpdateDTO.isAdmin());
		user.setSuperAdmin(userUpdateDTO.isSuperAdmin());
		user.setConfirmed(userUpdateDTO.isConfirmed());
		user.setCode(userUpdateDTO.getCode());
		user.setConfirmedAt(userUpdateDTO.getConfirmedAt());

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
