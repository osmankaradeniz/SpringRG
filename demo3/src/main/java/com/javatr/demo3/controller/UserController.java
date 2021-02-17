package com.javatr.demo3.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.javatr.demo3.dto.UserCreateDTO;
import com.javatr.demo3.dto.UserUpdateDTO;
import com.javatr.demo3.dto.UserViewDTO;
import com.javatr.demo3.model.User;
import com.javatr.demo3.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserController {

	private final UserService userService;

	// Tüm kullanıcıları sorgulama
	@GetMapping("/")
	public ModelAndView getUsers() {
		ModelAndView mav = new ModelAndView("user");
		List<UserViewDTO> users = userService.getUsers();
		mav.addObject("userData", users);
		return mav;
	}

	// id değerine göre kullanıcı sorgulama
	@GetMapping("v1/user/{id}")
	public ModelAndView getUser(@PathVariable long id) {
		ModelAndView mav = new ModelAndView("user");
		
		UserViewDTO user = userService.getUser(id);
		mav.addObject("userData", user);
		
		return mav;
	}

	
	
	// kullanıcı oluşturma formu
	@GetMapping("newUser")
	public ModelAndView getNewUserForm() {
		ModelAndView mav = new ModelAndView("newUser");
		User user = new User();
		mav.addObject("user", user);
		return mav;
	}

	// kullanıcı oluşturma işi
	@PostMapping("v1/user")
	public ModelAndView userCreate(@Valid @ModelAttribute("user") UserCreateDTO userCrateDTO) {

		userService.createUser(userCrateDTO);

		return new ModelAndView("redirect:/");
	}
	

	
	
	// kullanıcı güncelleme formu
	@GetMapping("/updateUser/{id}")
	public ModelAndView getUpdateForm(@PathVariable (value = "id") long id ) {
		ModelAndView mav = new ModelAndView("userUpdate");
		try {
		UserViewDTO user = userService.getUser(id);
		mav.addObject("user", user);	}
		catch(Exception ex){
			mav.addObject("errorMessage",ex.getMessage());
		}
		return mav;
	}

	// id değerine göre kullanıcıyı güncelleme
	@PostMapping("v1/user/{id}")
	public ModelAndView updateUser(@PathVariable long id, @Valid @ModelAttribute("user") UserUpdateDTO userUpdateDTO) {
		
		userService.updateUser(id, userUpdateDTO);

		 return new ModelAndView("redirect:/");
	}

	
	
	
	// id değerine göre kullanıcıyı silme
	@GetMapping("deleteUser/{id}")
	public ModelAndView deleteUser(@PathVariable long id) {
		userService.deleteUser(id);
		return new ModelAndView("redirect:/");
	}

}
