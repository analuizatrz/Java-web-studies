package com.luv2code.springsecurity.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogginController {
	@GetMapping("/showMyLoginPage")
	public String showMyLoginPage() {
		// return "plain-login";

		return "fancy-login";
	}
}