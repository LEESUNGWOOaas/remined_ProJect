package com.level.admin.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.level.admin.user.service.UserService;
import com.level.vo.PageVO;
import com.level.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper mapper;

	@Override
	public List<UserVO> selectUserList(UserVO userVO) throws Exception {
		if(userVO.isPaging()) userVO.setPageVO(new PageVO(userVO.getBlockSize(),userVO.getListSize(),userVO.getPage(),mapper.selectUserListCount(userVO)));
		return mapper.selectUserList(userVO);
	}

	@Override
	public UserVO selectUserById(String userId) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectUserById(userId);
	}
}
