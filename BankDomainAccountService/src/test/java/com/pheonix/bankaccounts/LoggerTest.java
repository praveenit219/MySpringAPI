package com.pheonix.bankaccounts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

	private static final Logger log = LoggerFactory.getLogger(LoggerTest.class);
	
	@Test
	public void test() {
		log.info("Im wiki");
		log.warn("Im wiki");
		log.error("Im wiki");
		log.debug("Im wiki");
	}

}
