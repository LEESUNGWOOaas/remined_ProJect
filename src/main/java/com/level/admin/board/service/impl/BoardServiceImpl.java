package com.level.admin.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.board.service.BoardService;
import com.level.vo.BoardInfoVO;
import com.level.vo.BoardVO;
import com.level.vo.PageVO;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper mapper;

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
	public int insert(BoardVO boardVO) throws Exception {
		if(boardVO.getBoardNo() == 0) {
			
		return mapper.insert(boardVO);
	}else {
		return mapper.update(boardVO);
		}
	}

	@Override
	public int delete(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(boardVO);
	}

	@Override
	public BoardVO selectBoard(BoardVO boardVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectBoard(boardVO);
	}
}
