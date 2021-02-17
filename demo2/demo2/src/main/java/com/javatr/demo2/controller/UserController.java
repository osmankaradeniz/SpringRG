package com.javatr.demo2.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatr.demo2.dto.UserCreateDTO;
import com.javatr.demo2.dto.UserUpdateDTO;
import com.javatr.demo2.dto.UserViewDTO;
import com.javatr.demo2.service.UserService;
import com.javatr.demo2.util.GenericResponse;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("api")
public class UserController {

	private final UserService userService;

	//Tüm kullanıcıları sorgulama 
	@GetMapping("v1/user")
	public ResponseEntity<List<UserViewDTO>> getUsers() {
		List<UserViewDTO> users = userService.getUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	// id değerine göre kullanıcı sorgulama
	@GetMapping("v1/user/{id}")
	public ResponseEntity<UserViewDTO> getUser(@PathVariable long id) {
		UserViewDTO user = userService.getUser(id);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	// kullanıcı oluşturma
	@PostMapping("v1/user")
	public ResponseEntity<?> userCreate(@Valid @RequestBody UserCreateDTO userCrateDTO) {
		userService.createUser(userCrateDTO);

		return ResponseEntity.ok(new GenericResponse("User Created !"));
	}
	
	// id değerine göre kullanıcıyı güncelleme
	@PutMapping("v1/user/{id}")
	public ResponseEntity<?> updateUser(@PathVariable long id, @Valid @RequestBody UserUpdateDTO userUpdateDTO) {
		userService.updateUser(id, userUpdateDTO);

		return ResponseEntity.ok(new GenericResponse("id :" + id + " User Updated !"));
	}

	// id değerine göre kullanıcıyı silme
	@DeleteMapping("v1/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable long id) {
		userService.deleteUser(id);

		return ResponseEntity.ok(new GenericResponse("User Deleted !"));
	}

}
