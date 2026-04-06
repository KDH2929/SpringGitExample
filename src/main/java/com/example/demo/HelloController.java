package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("/hello-test")
	@ResponseBody // 임시로 붙여서 테스트
	public String helloTest() {
	    return "This is a test";
	}

	@GetMapping("/hello")
	public String hello(@RequestParam(name = "name", required = false, defaultValue = "Guest") String name, Model model) {
	  
	    model.addAttribute("userName", name); 
	    model.addAttribute("serverTime", new java.util.Date().toString());
	    
	    return "hello";
	}
	
	@GetMapping("/home")
    public String goHome(Model model) {
        // HTML의 ${message} 부분에 들어갈 내용
        model.addAttribute("message", "홈 페이지에 오신 것을 환영합니다!");
        model.addAttribute("status", "서버가 정상적으로 작동 중입니다.");
        
        // src/main/resources/templates/home.html 을 호출
        return "home"; 
    }
}