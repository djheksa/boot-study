package com.study.mystudy.board.domain;

import java.util.List;

import org.springframework.util.StringUtils;

import lombok.Data;

@Data
public class PagingDto {
	private List<Board> boardList;
	private String searchCondition;
	private String keyword;
	private int startWith;
	private int pageSize;
	private boolean isSearch;
	
	public PagingDto( int currentPage
					, int pageSize
					, String searchCondition
					, String keyword) {
		
		if(StringUtils.hasText(keyword) && StringUtils.hasText(searchCondition)) {
			this.searchCondition = searchCondition;
			this.keyword = keyword;
			this.isSearch  = true;
		}
		if(currentPage == 0) currentPage= 1;
		this.startWith = (currentPage-1)*pageSize;
		this.pageSize = pageSize;
	}
	
	
	
}
