package com.pheonix.resources;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.pheonix.domain.Hello;

//@RestController
public class HelloController {
	
	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	
	//@Autowired
    RedisTemplate<String, Hello> redisTemplate;
	
	@RequestMapping(value = "/hello/{key}", method = RequestMethod.GET)
    public Hello get(@PathVariable("key") String key) {
        Hello hello = redisTemplate.opsForValue().get("hello:"+key);
        log.debug("{}", hello);
        return hello;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody Hello hello) {
        redisTemplate.opsForValue().set("hello:"+hello.getName(), hello);
    }

}
