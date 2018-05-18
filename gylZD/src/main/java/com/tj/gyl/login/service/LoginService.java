package com.tj.gyl.login.service;

import com.tj.gyl.domain.basedata.User;

 
public interface LoginService {
	public User authentication(String username,String password);
}
