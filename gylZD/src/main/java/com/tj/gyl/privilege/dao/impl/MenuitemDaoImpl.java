package com.tj.gyl.privilege.dao.impl;

import org.springframework.stereotype.Repository;

import com.tj.gyl.base.dao.impl.BaseDaoImpl;
import com.tj.gyl.domain.privilege.Menuitem;
import com.tj.gyl.privilege.dao.MenuitemDao;

@Repository("menuitemDao")
public class MenuitemDaoImpl extends BaseDaoImpl<Menuitem> implements MenuitemDao{

}
