package com.tj.gyl.privilege.service;

import java.util.Collection;

import com.tj.gyl.base.service.BaseService;
import com.tj.gyl.domain.privilege.Role;
 
public interface RoleService extends BaseService<Role>{
	public Role getRoleByName(String name);
	public Collection<Role> getRoleByUid(Long uid);
}
