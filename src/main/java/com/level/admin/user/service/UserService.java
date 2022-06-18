package com.level.admin.user.service;

import java.util.List;

import com.level.vo.UserVO;

public interface UserService {

	List<UserVO> selectUserList(UserVO userVO)throws Exception;

}
