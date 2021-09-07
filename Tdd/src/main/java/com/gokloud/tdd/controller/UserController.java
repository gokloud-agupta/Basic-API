package com.gokloud.tdd.controller;

import com.gokloud.tdd.dto.SaveUserDto;
import com.gokloud.tdd.model.User;
import com.gokloud.tdd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/user")
	public User getUser(@RequestParam Long userId){
		return userService.getUser(userId);
	}

	@PostMapping(value = "/user")
	public User saveUser(@RequestBody SaveUserDto userDto){
		return userService.saveUser(userDto);
	}

	@PutMapping(value = "/user")
	public User updateUser(@RequestBody SaveUserDto userDto,@RequestParam Long userId){
		return userService.updateUser(userDto,userId);
	}
}
