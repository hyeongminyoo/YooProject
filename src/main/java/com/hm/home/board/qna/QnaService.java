package com.hm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hm.home.util.Pager;

@Service
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		pager.getNum(qnaMapper.getCount(pager));

		return qnaMapper.getList(pager);
	}
	
}
