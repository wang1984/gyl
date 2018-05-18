package com.tj.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.base.service.impl.BaseServiceImpl;
import com.tj.gyl.basedata.dao.UserDao;
import com.tj.gyl.basedata.service.UserService;
import com.tj.gyl.domain.basedata.User;

 

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
	@Resource(name="userDao")
	private UserDao userDao;
	@Override
	public BaseDao getBaseDao() {
		 
		return this.userDao;
	}
	
}
