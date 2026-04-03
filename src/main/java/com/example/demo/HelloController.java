package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	@GetMapping("/")
	public @ResponseBody String index() {
		return "welcome home";
	}
	
	@GetMapping("/hello-test")
	@ResponseBody // 임시로 붙여서 테스트!
	public String helloTest() {
	    return "This is a test";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
	  
	    model.addAttribute("userName", name); 
	    model.addAttribute("serverTime", new java.util.Date().toString());
	    
	    return "hello";
	}
}