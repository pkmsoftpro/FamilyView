package com.miraclesoft.controller;

import javax.validation.Valid;
import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.miraclesoft.entity.User;
import com.miraclesoft.entity.UserDetail;
import com.miraclesoft.service.UseService;
import com.miraclesoft.service.UserService;

@RestController
@RequestMapping(value = "app")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UseService useService;

	@RequestMapping(method = RequestMethod.GET, value = "/userid/{id}")
	public UserDetail getUserWithId(@Min(1) @PathVariable Integer id) {

		return userService.getUserWithId(id);
	}

	@RequestMapping(value = "adduser", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public UserDetail addNewUser(@Valid @RequestBody UserDetail user) {
		return this.userService.addUser(user);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/user")
	@ResponseBody
	public User addUser(@RequestBody User user) {
		return this.useService.save(user);
	}
}