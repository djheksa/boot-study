package com.study.mystudy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.study.mystudy.user.domain.User;
import com.study.mystudy.user.repository.UserRepository;
import com.study.mystudy.user.service.UserService;

//@SpringBootTest
@Transactional
public class UserServiceTest {
	@Autowired UserService userService;
	@Autowired UserRepository userRepository;
	
//	@Test
//	public void 회원가입테스트() throws Exception{
//		System.out.println(userService);
//		User user = new User();
//		user.setName("hello");
//		
//		// When
//		Long saveId = userService.join(user);
//		// Then
//		User findUser = userRepository.findById(saveId).get();
//		assertEquals(user.getName(), findUser.getName());
//	}
	
	@Test
	public void 보드테스트() {
		
	}
}
