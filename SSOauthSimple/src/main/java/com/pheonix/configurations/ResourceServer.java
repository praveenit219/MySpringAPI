package com.pheonix.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServer extends ResourceServerConfigurerAdapter {
	
//	@Autowired
//	private CustomAuthenticationProvider authProvider;
//	
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.authenticationProvider(authProvider);
//	}
//
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		// @formatter:off
//		http
//			// Just for laughs, apply OAuth protection to only 2 resources
//			.requestMatcher(new OrRequestMatcher(
//				new AntPathRequestMatcher("/"), 
//				new AntPathRequestMatcher("/admin/beans")
//			))
//			.authorizeRequests()
//			.anyRequest().access("#oauth2.hasScope('read')");
//		// @formatter:on
//	}
//
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources)
//			throws Exception {
//		resources.resourceId("sparklr");
//	}

}