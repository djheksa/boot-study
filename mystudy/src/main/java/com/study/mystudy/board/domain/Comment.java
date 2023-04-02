package com.study.mystudy.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.study.mystudy.user.domain.User;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String content;
	private String authorIp;
	private LocalDateTime createdAt;
	private LocalDateTime modifiedAt;
	
	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "board_id", referencedColumnName = "id", nullable = false)
	private Board board;
	

	@Builder
	public Comment(String content, String authorIp) {
		this.content = content;
		this.authorIp = authorIp;
	}
	
    public void update(String content) {
        this.content = content;
        this.modifiedAt = LocalDateTime.now();
    }
	
}
