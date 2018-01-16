package com.linda.blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Result;
import com.linda.blog.entity.User;
import com.linda.blog.service.LoginService;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.SysConstant;

@Controller
@RequestMapping("/manager")
public class LoginController {
   @Autowired
   private LoginService loginService;
   
   @RequestMapping("/login")
   @ResponseBody
   public Object login(@RequestBody User user) {
   Result result = null;
   
	try {
		if(loginService.login(user.getUsername(), user.getPassword())) {
			result= new Result(SysConstant.STATE_SUCCESS,"login success",true); 
		}else {
			result= new Result(SysConstant.STATE_FAILURE,"login failure",false); 
		}
	} catch (Exception e) {
		result= new Result(SysConstant.STATE_FAILURE,"login failure",false); 
		e.printStackTrace();
	}
	 return JSONUtil.toJSON(result);
   } 
}
