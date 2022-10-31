package com.hm.home.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/qna/*")
@Slf4j
public class QnaController {
	@Autowired
	private QnaService qnaService;
	
	@GetMapping("list")
	public ModelAndView getList(Pager pager) throws Exception{
		ModelAndView mv = new ModelAndView();
		List<QnaVO> list = qnaService.getList(pager);
		mv.addObject("list", list);
		mv.addObject("pager", pager);
		mv.setViewName("board/list");
		
		return mv;
	}
}
