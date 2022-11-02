package com.hm.home.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.AbstractView;

import com.hm.home.board.qna.QnaFileVO;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class FileManager extends AbstractView {
	
	@Value("${app.download.base}")
	private String downUrl;
	
	
	public String saveFile(MultipartFile file, String path) throws Exception{
		
		//1.중복되지않는 파일명 생성
		String fileName = UUID.randomUUID().toString();
		
		//2. 확장자와 함께 버퍼에 추가
		StringBuffer bf = new StringBuffer();
		bf.append(fileName);
		
		//3.파일명과 확장자 분리
		String ex = file.getOriginalFilename();
		ex = ex.substring(ex.lastIndexOf("."));
		bf.append(ex);
		
		fileName = bf.toString();
		
		File uploadFile = new File(path,bf.toString());
		
		file.transferTo(uploadFile);
		
		return fileName;
	}

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		QnaFileVO qnaFileVO = (QnaFileVO)model.get("fileVO");
		String path = (String)model.get("path");
		log.info("-------------------------");
		log.info("FILEVO {}", qnaFileVO);
		
		File file = new File(downUrl+path, qnaFileVO.getFileName());
		
		//한글 처리
		response.setCharacterEncoding("UTF-8");
		
		//총 파일 크기
		response.setContentLengthLong(file.length());
		
		//다운로드 파일의 이름 인코딩
		String oriName = URLEncoder.encode(qnaFileVO.getOriName(), "UTF-8");
		
		//header 설정
		response.setHeader("Content-Disposition", "attachment;filename=\""+oriName+"\"");
		response.setHeader("Content-Transfer-Encoding", "binary");
		
		//HDD에서 파일 읽고
		FileInputStream fi = new FileInputStream(file);
		
		//클라이언트로 전송 준비 
		OutputStream os = response.getOutputStream();
		
		//전송
		FileCopyUtils.copy(fi, os);
		
		//자원해제
		os.close();
		fi.close();
		
	}
}
