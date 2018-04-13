package com.pheonix.configuration;

import java.net.UnknownHostException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
//@EnableCaching
@ComponentScan("com.pheonix")
public class RedisConfiguration {

	@Autowired
	RedisProperties redisProperties;

	//	@Bean
	//    public JedisConnectionFactory jedisConnectionFactory() {
	//        JedisConnectionFactory factory = new JedisConnectionFactory();
	//        
	//        return factory;
	//    }

	@Bean 
	@ConditionalOnMissingBean 
	public RedisConnectionFactory redisConnectionFactory() 
			throws UnknownHostException { 
		JedisConnectionFactory factory = 
				new JedisConnectionFactory(); 
		//factory.setHostName("localhost"); 
		//factory.setPort(6379); 
		return factory; 
	} 

	//	@Bean
	//    public RedisTemplate redisTemplate() {
	//        RedisTemplate redisTemplate = new RedisTemplate<>();
	//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
	//        redisTemplate.setKeySerializer(new StringRedisSerializer());
	//        redisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
	//        return redisTemplate;
	//    }

	@Bean 
	@Qualifier("redisTemplate")
	//@ConditionalOnMissingBean(name = "redisTemplate") 
	public RedisOperations<Object, Object> redisTemplate(
			RedisConnectionFactory redisConnectionFactory) 
					throws UnknownHostException { 
		RedisTemplate<Object, Object> template = new RedisTemplate<>(); 
		template.setConnectionFactory(redisConnectionFactory); 
		return template; 
	} 

	@Bean 
	@Qualifier("objectRedisTemplate")
	//@ConditionalOnMissingBean(name = "objectRedisTemplate") 
	public RedisTemplate<String, Object > objectRedisTemplate(
			RedisConnectionFactory redisConnectionFactory) { 
		RedisTemplate<String, Object > t = new RedisTemplate<>(); 
		t.setConnectionFactory(redisConnectionFactory); 
		t.setKeySerializer(new StringRedisSerializer()); 
		t.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class)); 
		t.afterPropertiesSet(); 
		return t; 
	} 

	@Bean
	@Qualifier("stringRedisTemplate")
	//@ConditionalOnMissingBean(StringRedisTemplate.class) 
	public StringRedisTemplate stringRedisTemplate(
			RedisConnectionFactory redisConnectionFactory) 
					throws UnknownHostException { 
		StringRedisTemplate template = new StringRedisTemplate(); 
		template.setConnectionFactory(redisConnectionFactory); 
		return template; 
	} 


	//	@Bean
	//    public CacheManager cacheManager() {
	//        return new RedisCacheManager(redisTemplate());
	//    }

}
