package com.linda.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Result;
import com.linda.blog.entity.User;
import com.linda.blog.service.UserService;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.SysConstant;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(@RequestBody User user) throws Exception {
		Result result = null;
		try {
			userService.addUser(user);
			result = new Result(SysConstant.STATE_SUCCESS, "add user success", null);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE, "add user failure", null);
		}
		return JSONUtil.toJSON(result);

	}

	public void deleteUserById(int id) {
		userService.deleteUserById(id);
	}

	public void updateUser(User user) {
		userService.updateUser(user);
	}

	public User getUserById(int id) {
		return userService.getUserById(id);

	}

	public List<User> getAllUsers() {
		return userService.getAllUsers();

	}

}
