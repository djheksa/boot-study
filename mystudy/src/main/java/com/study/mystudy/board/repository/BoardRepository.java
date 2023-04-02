package com.study.mystudy.board.repository;

import java.util.List;
import java.util.Optional;

import javax.persistence.Query;

import com.study.mystudy.board.domain.Board;
import com.study.mystudy.board.domain.PagingDto;

public interface BoardRepository {
	//전체글조회 검색조건 포함
	List<Board> findBoardList(PagingDto pagingdto);
	//단건글조회 - subject, userid, content, tag
	Optional<Board> findBoard(Long id);
	//글작성
	Board insert(Board board);
	//글수정
	int update(Board board);
	//글삭제
	Query delete(Board board, Long id);
	
}
