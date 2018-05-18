package com.tj.gyl.privilege.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.base.service.impl.BaseServiceImpl;
import com.tj.gyl.domain.privilege.Menuitem;
import com.tj.gyl.privilege.dao.MenuitemDao;
import com.tj.gyl.privilege.service.MenuitemService;

@Service("menuitemService")
public class MenuitemServiceImpl extends BaseServiceImpl<Menuitem> implements MenuitemService{
	@Resource(name="menuitemDao")
	private MenuitemDao menuitemDao;
	@Override
	public BaseDao getBaseDao() {
		// TODO Auto-generated method stub
		return this.menuitemDao;
	}
}
