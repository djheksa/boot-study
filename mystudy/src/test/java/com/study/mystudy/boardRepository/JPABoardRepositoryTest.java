package com.study.mystudy.boardRepository;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.study.mystudy.board.domain.Board;
import com.study.mystudy.board.domain.PagingDto;
import com.study.mystudy.board.repository.BoardRepository;
import com.study.mystudy.exception.CustomException;
import com.study.mystudy.exception.ErrorCode;
import com.study.mystudy.user.domain.User;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Transactional
@Slf4j
public class JPABoardRepositoryTest {

	@Autowired
	BoardRepository boardRepository;

//	@Test
	public void 전체글조회검색조건포함() {
		PagingDto r = new PagingDto(1, 5, "","");

		r.setBoardList(boardRepository.findBoardList(r));

		for (Board board : r.getBoardList()) {
			log.info(board.toString());
		}
	}

//	@Test
	public void 글상세() {
		Board result = boardRepository.findBoard(2L).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		log.info(result.toString());
	}

	@Test
	@Commit
	public void 글수정() {
		Board board = Board.builder()
				.title("여행")
				.content("부산......")
				.views(10)
				.userIp("127.0.0.1")
				.tagCode(10L)
				.user(User.builder().id(2L).name("오정현").build())
				.build();
		
		Board entity = boardRepository.findBoard(1L).orElseThrow(() -> new CustomException(ErrorCode.POSTS_NOT_FOUND));
		System.out.println(entity.getId()+"sadasddasds");
		entity.update(board.getTitle(), board.getContent(), board.getTag_code());
		int result = boardRepository.update(entity);
	}
	
}
