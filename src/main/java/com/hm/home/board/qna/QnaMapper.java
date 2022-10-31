package com.hm.home.board.qna;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hm.home.util.Pager;

@Mapper
public interface QnaMapper {
	
	public List<QnaVO> getList(Pager pager) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
	
	public int setAdd(QnaVO qnaVO) throws Exception;
}
