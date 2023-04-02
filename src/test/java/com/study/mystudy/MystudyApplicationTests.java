package com.study.mystudy;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.study.*"})
@SpringBootTest
class MystudyApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("test");
	}

}
