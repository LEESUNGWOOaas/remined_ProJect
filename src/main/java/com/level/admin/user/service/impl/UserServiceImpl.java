package com.level.admin.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.level.admin.user.service.UserService;
import com.level.common.util.SHA256Util;
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

	@Override
	public UserVO selectUser(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectUser(userVO);
	}

	@Override
	public int insert(UserVO userVO) throws Exception {
		if(userVO.getUserNo() == 0) {
			userVO.setHash(SHA256Util.generateSalt());
			userVO.setPwd(SHA256Util.getEncrypt(userVO.getPwd(), userVO.getHash()));
			return mapper.insert(userVO);
		}else {
			if(StringUtils.hasText(userVO.getPwd())){
				UserVO memberVO = mapper.selectUserByUserNo(userVO.getUserNo());
				userVO.setPwd(SHA256Util.getEncrypt(userVO.getPwd(), memberVO.getHash()));
			}
			return mapper.update(userVO);
		}
	}

	@Override
	public int delete(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.delete(userVO);
	}

	@Override
	public int update(UserVO userVO) throws Exception {
		// TODO Auto-generated method stub
		return mapper.update(userVO);
	}
}
