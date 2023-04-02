package com.study.mystudy.user.repository;

import java.util.List;
import java.util.Optional;

import com.study.mystudy.user.domain.User;

public interface UserRepository {	//최상위 이 밑으로 생기는 모든 user 관련 repository 해당 인터페이스를 상속받아야함
	Optional<User> findByName(String name);	//select * from user whrer name = 'hello';
	Optional<User> findById(Long name);
	User save(User user);
	List<User> findAll();
}
