package com.tj.gyl.privilege.dao;

import java.util.Collection;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.domain.privilege.Privilege;

 

public interface PrivilegeDao extends BaseDao<Privilege>{
	public Collection<Privilege> getPrivilegesByRid(Long rid);
	
	public Collection<Privilege> getMenuitemTreeByUid(Long uid);
	
	public Collection<Privilege> getFunctionByUid(Long uid);
}
