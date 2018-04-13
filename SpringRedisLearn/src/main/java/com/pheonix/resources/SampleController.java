package com.pheonix.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pheonix.domain.User;

//@RestController
public class SampleController {

	private static final Logger log = LoggerFactory.getLogger(SampleController.class);


	@Autowired
	RedisOperations<Object, Object> redisTemplate;

	@RequestMapping(value = "/user/{key}", method = RequestMethod.GET)
	public User get(@PathVariable("key") String key) {
		User user = null;
		Object obj = redisTemplate.opsForValue().get("user:"+key);
		if(obj instanceof User) {
			user = (User) obj;
			log.debug("{}", user);
		}
				
		return user;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void save(@RequestBody User user) {
		redisTemplate.opsForValue().set("user:"+user.getId(), user);
	}


}
