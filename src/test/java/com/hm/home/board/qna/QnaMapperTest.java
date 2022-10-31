package com.hm.home.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@SpringBootTest
class QnaMapperTest {
	
	@Autowired
	private QnaMapper qnaMapper;
	
	
//	@Test
	void test() throws Exception {
		for(int i=1; i<101; i++) {
			QnaVO qnaVO = new QnaVO();
			qnaVO.setTitle("title"+i);
			qnaVO.setWriter("writer"+i);
			qnaVO.setContents("contents"+i);
			qnaMapper.setAdd(qnaVO);
			if(i%20 == 0) {
				Thread.sleep(1000);
			}
		}
		
		System.out.println("FINISH!");
	}

}
