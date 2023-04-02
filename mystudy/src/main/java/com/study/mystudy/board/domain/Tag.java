package com.study.mystudy.board.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor// 기본생성자
public class Tag {
	//entity setter X
	
	@Id
	private Long code;
	private String tagName;
	private LocalDateTime createdAt;
	private String createdBy;
	private String modifiedBy;
	private LocalDateTime modifiedAt;
	
	@Builder
	public Tag(Long code, String tagName, String createdBy) {
		this.code = code;
		this.tagName = tagName;
		this.createdBy = createdBy;
	}
	
	public void update(Long code, String tagName) {
        this.code = code;
        this.tagName = tagName;
        this.modifiedAt = LocalDateTime.now();
    }
}
