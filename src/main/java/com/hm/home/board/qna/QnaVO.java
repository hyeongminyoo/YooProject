package com.hm.home.board.qna;

import java.sql.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
@Data
public class QnaVO {
	
	private Long num;
	@NotBlank
	@Size(min = 4, max = 20)
	private String title;
	@NotBlank
	@Size(min = 4, max = 20)
	private String writer;
	@NotBlank
	private String contents;
	private Date regDate;
	private Long hit;
	private Long ref;
	private Long depth;
	private Long step;
	
	private MultipartFile [] files;
	
}
