package com.pheonix.controller;

import javax.servlet.FilterConfig;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestsController {
	
	private static final org.slf4j.Logger log = LoggerFactory.getLogger(FilterConfig.class);
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String checkIpFilter() {
		
		log.debug("inside checkIpFilter RestController");
		
		return "tested";
	}

}
