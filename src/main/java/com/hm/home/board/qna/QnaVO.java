package com.hm.home.board.qna;

import java.sql.Date;

import lombok.Data;
@Data
public class QnaVO {
	
	private Long num;
	private String title;
	private String writer;
	private String contents;
	private Date regDate;
	private Long hit;
	private Long ref;
	private Long depth;
	private Long step;
}
