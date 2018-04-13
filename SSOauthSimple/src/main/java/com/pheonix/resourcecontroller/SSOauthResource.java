package com.pheonix.resourcecontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SSOauthResource {
	
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

}
