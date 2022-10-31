package com.hm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/qna/*")
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public void getList() throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaVO> list = qnaService.getList();
		mv.addObject("list", list);
		mv.setViewName("board/list");
	}
}
