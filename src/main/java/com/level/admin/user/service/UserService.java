package com.level.admin.user.service;

import java.util.List;

import com.level.vo.UserVO;

public interface UserService {

	List<UserVO> selectUserList(UserVO userVO) throws Exception;

	UserVO selectUserById(String userId) throws Exception;

	UserVO selectUser(UserVO userVO)throws Exception;

	int insert(UserVO userVO)throws Exception;

	int delete(UserVO userVO)throws Exception;


}
