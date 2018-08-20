package com.linda.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.Result;
import com.linda.blog.entity.User;
import com.linda.blog.service.LoginService;
import com.linda.blog.utils.CheckResult;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.JWT;
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
	   Map<String, Object> data = new HashMap<String, Object>();
	   
		try {
			if(loginService.login(user.getUsername(), user.getPassword())) {
				String token = JWT.createJWT(user.getUsername(), user.getPassword(), 24*60*60*1000);
				data.put("token", token);
				result= new Result(SysConstant.STATE_SUCCESS,"login success",data); 
			}else {
				result= new Result(SysConstant.STATE_FAILURE,"login failure",false); 
			}
		} catch (Exception e) {
			result= new Result(SysConstant.STATE_FAILURE,"login failure",false); 
			e.printStackTrace();
		}
		 return JSONUtil.toJSON(result);
   } 
   
   @RequestMapping("/autoLogin")
   @ResponseBody 
   public Object autoLogin(@RequestParam("token") String token) {
	   Result result = null;
	   try {
		   CheckResult  cr = JWT.validateJWT(token);
		   if(cr.isSuccess()) {
			   result= new Result(SysConstant.STATE_SUCCESS,"auto login success",true);
		   } else {
			   result= new Result(SysConstant.STATE_FAILURE,"auto login failure",false);
		   }
	   } catch (Exception e) {
		   result= new Result(SysConstant.STATE_FAILURE,"auto login failure",false);
		   e.printStackTrace();
	   }
	 return JSONUtil.toJSON(result);
   }
}
