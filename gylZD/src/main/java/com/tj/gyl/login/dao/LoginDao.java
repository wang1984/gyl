package com.tj.gyl.login.dao;

import com.tj.gyl.domain.basedata.User;

 
/**
 * 
 * login.dao 与原来重构的dao没有什么关系
 * @author Administrator
 *
 */
public interface LoginDao {
	//认证方法
	public User authentication(String username,String password);
}
