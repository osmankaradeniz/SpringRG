package com.javatr.demo.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatr.demo.dto.UserCreateDTO;
import com.javatr.demo.dto.UserUpdateDTO;
import com.javatr.demo.dto.UserViewDTO;
import com.javatr.demo.service.UserService;
import com.javatr.demo.util.GenericResponse;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserAPI {

	private final UserService userService;
	
	@GetMapping("/v1/user/{id}")
	public ResponseEntity<UserViewDTO> getUserById(@PathVariable Long id){
		final UserViewDTO user = userService.getUserById(id);
		return ResponseEntity.ok(user);
	}
	
	
	@GetMapping("v1/user")
	public ResponseEntity<List<UserViewDTO>> getUsers(){
		final List<UserViewDTO> users = userService.getUsers();
		return ResponseEntity.ok(users);
	}
	
	
	@PostMapping("v1/user")
	public ResponseEntity<?> createUser(@Valid @RequestBody UserCreateDTO userCreateDTO)
	{
		userService.CreateUser(userCreateDTO);
		
		return ResponseEntity.ok(new GenericResponse("User Created."));
	}
	
	
	@PutMapping("v1/user/{id}")
	public ResponseEntity<UserViewDTO> updateUser(@PathVariable Long id,@RequestBody UserUpdateDTO UserUpdateDTO)
	{
		final UserViewDTO user = userService.updateUser(id,UserUpdateDTO);
		
		return ResponseEntity.ok(user);
	}
	
	
	@DeleteMapping("v1/user/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable Long id)
	{
		userService.deleteUser(id);
		return ResponseEntity.ok(new GenericResponse("User Deleted !"));
	}
	
	// ?page=x&size=y pagination
	@GetMapping("v1/user/slice")
	public ResponseEntity<List<UserViewDTO>> slice(Pageable pageable)
	{
		final List<UserViewDTO> users = userService.slice(pageable);
		return ResponseEntity.ok(users);
		
	}
	
	
	
	
}
