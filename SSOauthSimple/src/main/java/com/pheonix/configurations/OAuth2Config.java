package com.pheonix.configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

@Configuration
@EnableAuthorizationServer
public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsService userDetailsService;

	@Value("${gigy.oauth.tokenTimeout:3600}")
	private int expiration;

	@Autowired
	private AuthenticationManager authenticationManager;

	// password encryptor
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints)
			throws Exception {
		endpoints.authenticationManager(authenticationManager);
		endpoints.userDetailsService(userDetailsService);
	}

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
//		clients.inMemory().withClient("my-trusted-client")
//		.authorizedGrantTypes("password", "authorization_code",
//				"refresh_token", "implicit")
//		.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//		.scopes("read", "write", "trust").resourceIds("sparklr")
//		.accessTokenValiditySeconds(60).and()
//		.withClient("my-client-with-registered-redirect")
//		.authorizedGrantTypes("authorization_code").authorities("ROLE_CLIENT")
//		.scopes("read", "trust").resourceIds("sparklr")
//		.redirectUris("http://anywhere?key=value").and()
//		.withClient("my-client-with-secret")
//		.authorizedGrantTypes("client_credentials", "password")
//		.authorities("ROLE_CLIENT").scopes("read").resourceIds("sparklr")
//		.secret("secret");
		
		clients.inMemory().withClient("gigy").secret("secret").accessTokenValiditySeconds(expiration)
		.scopes("read", "write").authorizedGrantTypes("password", "refresh_token").resourceIds("resource");
		
	}

}
