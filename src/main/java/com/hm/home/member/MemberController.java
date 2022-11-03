package com.hm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("login")
	public void getLogin() throws Exception{
		
	}
	
	@GetMapping("join")
	public void setJoin() throws Exception{
		
	}
	
	@PostMapping("join")
	public String setJoin(MemberVO memberVO) throws Exception{
		memberService.setJoin(memberVO);
		return "redirect:./login";
	}
	
}
