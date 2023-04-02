package com.study.mystudy.config;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.study.mystudy.board.repository.BoardRepository;
import com.study.mystudy.board.repository.JpaBoardRepository;
import com.study.mystudy.user.repository.UserRepository;
import com.study.mystudy.user.service.UserService;

@Configuration
public class ApplicationConfig {
	private final UserRepository userRepository;
	private final DataSource dataSource;
	private final EntityManager em;

	public ApplicationConfig(UserRepository userRepository, DataSource dataSource, EntityManager em) {
		this.userRepository = userRepository;
		this.dataSource = dataSource;
		this.em = em;
	}

	@Bean
	public UserService userService() {
		return new UserService(userRepository);
	}

	@Bean
	public BoardRepository boardRepository() {
		return new JpaBoardRepository(em);
	}

}
