package com.linda.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Result;
import com.linda.blog.entity.User;
import com.linda.blog.service.UserService;
import com.linda.blog.utils.GenerateUniqueID;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.Log;
import com.linda.blog.utils.MD5Util;
import com.linda.blog.utils.SysConstant;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
 
	@RequestMapping("/addUser")
	@ResponseBody
	public Object addUser(@RequestBody User user) throws Exception{
		Log.debug("UserController:/user/addUser save id = " + user.getUid());
		Result result = null;
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("user", null);
		user.setUid(GenerateUniqueID.generateUserId());
		user.setPassword(MD5Util.getMD5String(user.getPassword()));
		try {
			userService.addUser(user);
			result = new Result(SysConstant.STATE_SUCCESS, "add user success", data);
		} catch (Exception e) {
			e.printStackTrace();
			result = new Result(SysConstant.STATE_FAILURE, "add user failure", data);
		}
		return JSONUtil.toJSON(result);

	}
	@RequestMapping("/deleteUserById")
	@ResponseBody
	public Object deleteUserById(String id) throws Exception {
		Log.info("UserController:/user/deleteUserById delete id = " + id);
		Result result = null;
		if(StringUtils.isNotBlank(id)) {
			result = new Result(SysConstant.STATE_FAILURE, "user id is null", null);
		}else {
			try {
				userService.deleteUserById(id);
				result = new Result(SysConstant.STATE_SUCCESS, "delete user success", null);
			}catch(Exception e) {
				e.printStackTrace();
				result = new Result(SysConstant.STATE_FAILURE, "delete user failure", null);
			}	
		}
		return JSONUtil.toJSON(result);
	}
	
	@RequestMapping("/updateUser")
	@ResponseBody
	public Object updateUser(@RequestBody User user) throws Exception{
		Result result = null;
		if(user == null) {
			result = new Result(SysConstant.STATE_FAILURE, "user can't be null when you update the user", null);
		}else {
			try {
				userService.updateUser(user);
				result = new Result(SysConstant.STATE_SUCCESS, "update user success", null);
			}catch (Exception e) {
				e.printStackTrace();
				result = new Result(SysConstant.STATE_FAILURE, "update user failure", null);
			}
		}
		return JSONUtil.toJSON(result);
	}
	@RequestMapping("/getUserById")
	@ResponseBody
	public Object getUserById(String id) throws Exception {
		Result result = null;
		User user = null;
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			user = userService.getUserById(id);
			if(user!=null) {
				data.put("user", user);
				result = new Result(SysConstant.STATE_SUCCESS,"getUserById Success",data);
			}else {
				data.put("user", null);
				result = new Result(SysConstant.STATE_FAILURE,"getUserById failure",data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return JSONUtil.toJSON(result);

	}
	@RequestMapping("/getAllUsers")
	@ResponseBody
	public Object getAllUsers() throws Exception {
		Result result = null;
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			 List<User> userList = userService.getAllUsers();
			 data.put("users", userList);
			 data.put("userCount", userList.size());
			 result = new Result(SysConstant.STATE_SUCCESS,"getAllUsers Success",data);
		} catch (Exception e) {
			e.printStackTrace();
			data.put("users", null);
			result = new Result(SysConstant.STATE_FAILURE,"getAllUsers failure",data);
		}
		return JSONUtil.toJSON(result);

	}

}
