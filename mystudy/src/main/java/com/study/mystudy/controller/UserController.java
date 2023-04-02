package com.study.mystudy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.mystudy.user.domain.User;
import com.study.mystudy.user.service.UserService;

@RestController
public class UserController {
	private final UserService userService;
	
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping("/join")
	public Long join(@RequestParam User user) {
		return userService.join(user);
	}
}
