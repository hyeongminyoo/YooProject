package com.hm.home.board.qna;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hm.home.util.FileManager;
import com.hm.home.util.Pager;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class QnaService {
	
	@Autowired
	private QnaMapper qnaMapper;
	@Autowired
	private FileManager fileManager;
	@Value("${app.upload.qna}")
	private String path;
	
	
	
	public List<QnaVO> getList(Pager pager) throws Exception{
		pager.getNum(qnaMapper.getCount(pager));

		return qnaMapper.getList(pager);
	}
	
	public int setAdd(QnaVO qnaVO) throws Exception{
		
		int result = qnaMapper.setAdd(qnaVO);
		
		File file = new File(path);
		if(!file.exists()) {
			file.mkdirs();
		}
		
		for(MultipartFile f : qnaVO.getFiles()) {
			if(!f.isEmpty()) {
				log.info("FileName : {}", f.getOriginalFilename());
				String fileName = fileManager.saveFile(f, path);
				QnaFileVO qnaFileVO = new QnaFileVO();
				qnaFileVO.setNum(qnaVO.getNum());
				qnaFileVO.setOriName(f.getOriginalFilename());;
				qnaFileVO.setFileName(fileName);
				qnaMapper.setFileAdd(qnaFileVO);
			}
		}
		
		return result;
	}
	
	public QnaVO getDetail(QnaVO qnaVO) throws Exception{
		return qnaMapper.getDetail(qnaVO);
	}
	
	public QnaFileVO getFileDetail(QnaFileVO qnaFileVO) throws Exception{
		return qnaMapper.getFileDetail(qnaFileVO);
	}
}
