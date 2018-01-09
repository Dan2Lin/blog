package com.linda.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.linda.blog.entity.ArticleType;
import com.linda.blog.entity.Result;
import com.linda.blog.service.ArticleTypeService;
import com.linda.blog.utils.JSONUtil;
import com.linda.blog.utils.SysConstant;

@Controller
@RequestMapping("/articleType")
public class ArticleTypeController {
	@Autowired
	private ArticleTypeService articleTypeService;

	@RequestMapping("/getAllArticleType")
	@ResponseBody
	public Object getAllArticleType() {
		Result result = null;
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			List<ArticleType> articleTypeList = articleTypeService.getAllArticleType();
			data.put("articleTypes", articleTypeList);
			data.put("articleTypesCount", articleTypeList.size());
			result = new Result(SysConstant.STATE_SUCCESS,"getAllArticleType success",data);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"getAllArticleType failure",data);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}
	@RequestMapping("/getArticleTypeById")
	@ResponseBody
	public Object getArticleTypeById(String id) {
		 Result result = null;
		 Map<String, Object> data = new HashMap<String, Object>();
		 try {
			ArticleType articleType = articleTypeService.getArticleTypeById(id);
			data.put("articleType", articleType);
			result = new Result(SysConstant.STATE_SUCCESS,"getArticleTypeById success",data);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"getArticleTypeById failure",data);
			e.printStackTrace();
		}
		 return JSONUtil.toJSON(result);
	}
	@RequestMapping("/addArticleType")
	@ResponseBody
	public Object addArticleType(@RequestBody ArticleType articleType) {
		Result result = null;
		try {
			articleTypeService.addArticleType(articleType);
			result = new Result(SysConstant.STATE_SUCCESS,"addArticleType success",null);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"addArticleType failure",null);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}
	@RequestMapping("/updateArticleType")
	@ResponseBody
	public Object updateArticleType(@RequestBody ArticleType articleType) {
		Result result = null;
		try {
			articleTypeService.updateArticleType(articleType);
			result = new Result(SysConstant.STATE_SUCCESS,"updateArticleType success",null);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"updateArticleType failure",null);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}
	@RequestMapping("/deleteArticleTypeById")
	@ResponseBody
	public Object deleteArticleTypeById(String id) {
		Result result = null;
		try {
			articleTypeService.deleteArticleTypeById(id);
			result = new Result(SysConstant.STATE_SUCCESS,"deleteArticleTypeById#"+id+" success",null);
		} catch (Exception e) {
			result = new Result(SysConstant.STATE_FAILURE,"deleteArticleTypeById#"+id+" failure",null);
			e.printStackTrace();
		}
		return JSONUtil.toJSON(result);
	}
}
