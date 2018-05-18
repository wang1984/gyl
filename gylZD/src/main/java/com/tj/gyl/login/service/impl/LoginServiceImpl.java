package com.tj.gyl.login.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.domain.basedata.User;
import com.tj.gyl.login.dao.LoginDao;
import com.tj.gyl.login.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	@Resource(name="loginDao")
	private LoginDao loginDao;

	@Override
	public User authentication(String username, String password) {
		 
		return this.loginDao.authentication(username, password);
	}
}
