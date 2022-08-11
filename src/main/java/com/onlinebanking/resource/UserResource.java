package com.onlinebanking.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.onlinebanking.entity.User;
import com.onlinebanking.service.UserService;

/**
 * Created by IntelliJ IDEA. Project : online-banking User: hendisantika Email:
 * hendisantika@gmail.com Telegram : @hendisantika34 Date: 04/09/18 Time: 06.39
 * To change this template use File | Settings | File Templates.
 */
@RestController
@RequestMapping("/api")
@PreAuthorize("hasRole('ADMIN')")
public class UserResource {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public List<User> userList() {
		return userService.findUserList();
	}

	@RequestMapping("/user/{username}/enable")
	public void enableUser(@PathVariable("username") String username) {
		userService.enableUser(username);
	}

	@RequestMapping("/user/{username}/disable")
	public void diableUser(@PathVariable("username") String username) {
		userService.disableUser(username);
	}
}
