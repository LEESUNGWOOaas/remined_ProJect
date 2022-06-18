package com.level.admin.user.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.level.vo.UserVO;

@Mapper
public interface UserMapper {

	List<UserVO> selectUserList(UserVO userVO)throws Exception;
	
	int selectUserListCount(UserVO userVO)throws Exception;
}
