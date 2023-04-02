package com.study.mystudy.board.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.study.mystudy.board.domain.Board;
import com.study.mystudy.board.domain.PagingDto;
import com.study.mystudy.user.domain.User;

public class JpaBoardRepository implements BoardRepository {
	
	private final EntityManager em;

	public JpaBoardRepository(EntityManager em) {
		this.em = em;
	}

	// repository에 작성되는 메서드의 기준은 쿼리문 하나 기준으로 작성됨

	@Override
	public List<Board> findBoardList(PagingDto pagingDto) {
		String queryStr = "select a from Board a";
		if (pagingDto.isSearch()) {
			switch (pagingDto.getSearchCondition()) {
			case "content":
				queryStr += " where a.content Like :keyword";
				break;
			case "title":
				queryStr += " where a.title Like :keyword";
				break;
			default:
				queryStr += " order by id desc";
				break;
			}
		}
		TypedQuery<Board> query = em.createQuery(queryStr, Board.class);

		if (pagingDto.isSearch()) {
			query.setParameter("keyword", "%" + pagingDto.getKeyword() + "%");
		}
		query.setFirstResult(pagingDto.getStartWith()).setMaxResults(pagingDto.getPageSize());
		return query.getResultList();
	}

	@Override
	public Optional<Board> findBoard(Long id) {
		Board board = em.find(Board.class, id);
		return Optional.ofNullable(board);
	}

	@Override
	public Query delete(Board board, Long id) {

		String queryStr = "delete from Board a where a.id = :boardId";
		Query result = em.createQuery(queryStr)
		.setParameter("boardId",id);
		return result;
	}

	@Override
	public Board insert(Board board) {

		String queryStr = "INSERT INTO Board(b.title, b.content, b.userIp, b.tagCode, b.user) "
				+ "VALUES(:title, :content, :authorIp, :tagCode, :user)";

		TypedQuery<Board> query = em.createQuery(queryStr, Board.class);
		query.setParameter("title", board.getTitle());
		query.setParameter("content", board.getContent());
		query.setParameter("userIp", board.getUserIp());
		query.setParameter("tagCode", 10);
		query.setParameter("user", board.getUser().getId());
		query.executeUpdate();

		return em.find(Board.class, board.getId());
	}

	@Override
	public int update(Board board) {

		String queryStr = "update Board a set a.title = :title, a.content = :content, a.tag_code = :tagCode  where a.id = :boardId";
		int result = em.createQuery(queryStr)
		.setParameter("title", board.getTitle())
		.setParameter("content", board.getContent())
		.setParameter("tagCode", board.getTag_code())
		.setParameter("boardId", board.getId())
		.executeUpdate();
		
		em.clear();
		return result;
	}

}
