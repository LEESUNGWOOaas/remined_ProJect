package com.level.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.level.admin.board.service.BoardService;
import com.level.common.file.service.FileService;
import com.level.vo.BoardInfoVO;
import com.level.vo.BoardVO;
import com.level.vo.FileVO;
import com.level.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;
	@Autowired
	FileService fileService;
	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) throws Exception {
		if(boardVO.isPaging()) boardVO.setPageVO(new PageVO(boardVO.getBlockSize(),boardVO.getListSize(),boardVO.getPage(),mapper.selectBoardListCount(boardVO)));
		return mapper.selectBoardList(boardVO);
	}

	@Override
	public BoardInfoVO selectBoardInfo(BoardInfoVO boardInfoVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoardInfo(boardInfoVO);
	}
	
	@Override
	public BoardVO selectBoard(BoardVO boardVO) throws Exception {
		boardVO = mapper.selectBoard(boardVO);
		if(boardVO!=null) {
			boardVO.setFileList(fileService.selectFileList(new FileVO(boardVO.getProcess(),boardVO.getBoardNo(),"File")));
		}
		return boardVO;
	}
	
	@Override
	public int insert(BoardVO boardVO,MultipartHttpServletRequest multipart) throws Exception {
		int result = 0;
		
		if(boardVO.getBoardNo() == 0) {
		result = mapper.insert(boardVO);
	}else {
		result = mapper.update(boardVO);
		}
	
		if(result>0) {
			MultipartFile multi = multipart.getFile("File");
			FileVO fileVO = fileService.saveFile(multi,boardVO.getProcess(),boardVO.getBoardNo(),"File");
			if(fileVO!=null) {
				System.out.println("fileVO.getFileNo( = "+fileVO.getFileNo());
				fileVO.setExceptNo(fileVO.getFileNo());
				fileService.deleteOldFile(fileVO);	
			}
		}
		return result;
		
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		int result=mapper.delete(boardVO);
		if(result > 0) {
			FileVO fileVO = new FileVO();
			fileVO.setRef(boardVO.getBoardNo());			
			fileService.deleteOldFile(fileVO);
			}
		return result;
		}

	

	@Override
	public int update(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(boardVO);
	}
}
