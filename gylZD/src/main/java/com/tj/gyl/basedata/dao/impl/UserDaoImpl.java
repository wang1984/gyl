package com.tj.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.tj.gyl.base.dao.impl.BaseDaoImpl;
import com.tj.gyl.basedata.dao.UserDao;
import com.tj.gyl.domain.basedata.User;

@Repository("userDao")
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao{

}
