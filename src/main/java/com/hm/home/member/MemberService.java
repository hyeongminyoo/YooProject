package com.hm.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public int setJoin(MemberVO memberVO) throws Exception{
		memberVO.setPw(passwordEncoder.encode(memberVO.getPw()));
		memberMapper.setJoin(memberVO);
		return memberMapper.setMemberRole(memberVO);
	}
	
}
