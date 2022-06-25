package com.level.admin.board.service;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.level.vo.BoardInfoVO;
import com.level.vo.BoardVO;


public interface BoardService {

	List<BoardVO> selectBoardList(BoardVO boardVO)throws Exception;

	BoardInfoVO selectBoardInfo(BoardInfoVO boardInfoVO)throws Exception;

	int insert(BoardVO boardVO, MultipartHttpServletRequest multipart)throws Exception;

	int delete(BoardVO boardVO)throws Exception;

	BoardVO selectBoard(BoardVO boardVO)throws Exception;

	int update(BoardVO boardVO)throws Exception;

}
