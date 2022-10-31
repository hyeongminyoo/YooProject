package com.hm.home.util;

import lombok.Data;

@Data
public class Pager {
	
	private Long page;
	private Long startNum;
	private Long lastNum;
	private Long perPage;
	private Long perBlock;
	private Long totalPage;
	private Long startRow;
	
	private boolean pre;
	private boolean next;
	
	private String kind;
	private String search;
	
	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		return search;
	}
	
	public Pager() {
		this.perPage = 10L;
		this.perBlock = 5L;
	}
	
	public Long getPage() {
		if(this.page == null || this.page <=0) {
			this.page = 1L;
		}
		return page;
	}
	
	//mapper용 스타트로우
	public Long getStartRow() {
		this.startRow = (this.getPage()-1)*this.getPerPage();
		return startRow;
	}
	
	//jsp 에서 쓸 startnum
	public void getNum(Long totalCount) throws Exception{
		//1. 받은 totalCount로 전체 페이지 구하기
		Long totalPage = totalCount/this.getPerPage();
		if(totalCount%this.getPerPage() != 0) {
			totalPage++;
		}
		
		this.totalPage = totalPage;
		
		//2. 전체 페이지로 전체 블럭 구하기
		Long totalBlock = totalPage/this.getPerBlock();
		if(totalPage%this.getPerBlock() != 0) {
			totalBlock++;
		}
		
		//3. page 번호로 현재 블럭의 번호 구하기
		Long curBlock = this.getPage()/this.getPerBlock();
		if(this.getPage()%this.getPerBlock() != 0) {
			curBlock++;
		}
		
		//4. Curblock으로 시작번호 및 끝번호
		this.startNum = (curBlock-1)*this.getPerBlock()+1;
		this.lastNum = curBlock*this.getPerBlock();
		
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
		if(curBlock > 1) {
			pre = true;
		}
		
		if(curBlock<totalBlock) {
			next = true;
		}
	}
	
}
