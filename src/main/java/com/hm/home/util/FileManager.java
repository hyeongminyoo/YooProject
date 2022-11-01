package com.hm.home.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileManager {
	
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
}
