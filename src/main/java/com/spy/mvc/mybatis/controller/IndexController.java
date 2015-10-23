package com.spy.mvc.mybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spy.mvc.mybatis.service.UserService;

/**
 * @author spy
 *
 * @datetime 2015年10月23日 下午3:21:49
 */
@Controller
@RequestMapping("/test")
public class IndexController {

	@Autowired
	private UserService UserService;

	@RequestMapping("/test")
	@ResponseBody
	public String test() {

		return "this is body";
	}

}
