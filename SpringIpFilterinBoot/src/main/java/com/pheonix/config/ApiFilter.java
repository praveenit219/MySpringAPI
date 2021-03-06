package com.pheonix.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class ApiFilter extends OncePerRequestFilter {

	private static final org.slf4j.Logger log = LoggerFactory.getLogger(ApiFilter.class);


	


	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws ServletException, IOException {
		log.debug("inside Api chain");
		log.debug("request ip with forwarded by: " + req.getHeader("X-FORWARDED-BY"));
		log.debug("request has ip with remoteAddr: "+req.getRemoteAddr());
		log.debug("request has ip with Parameter : "+req.getParameter("X-FORWARDED-BY"));
		chain.doFilter(req, res);
	}

}
