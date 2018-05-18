package com.tj.gyl.privilege.dao;

import java.util.Collection;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.domain.privilege.Role;

 

public interface RoleDao extends BaseDao<Role>{
	public Role getRoleByName(final String name);
	public Collection<Role> getRoleByUid(Long uid);
}
