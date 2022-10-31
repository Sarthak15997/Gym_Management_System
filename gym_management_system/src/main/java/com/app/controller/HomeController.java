package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	public HomeController() {
		System.out.println("in home controller");
	}
	
	@GetMapping("/")
	public String showHomePage() {
		System.out.println("show home page "+getClass().getName());
		return "/index";
	}
	@GetMapping("/error")
	public String handleErrorPage() {
		return "/";
	}
	
	@GetMapping("/gallery")
	public String showGallary() {
		return "/gallery";
	}
	
}
