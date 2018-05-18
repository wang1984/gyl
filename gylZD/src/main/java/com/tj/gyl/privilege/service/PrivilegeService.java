package com.tj.gyl.privilege.service;

import java.util.Collection;

import com.tj.gyl.base.service.BaseService;
import com.tj.gyl.domain.privilege.Privilege;

 

public interface PrivilegeService extends BaseService<Privilege>{
	public Collection<Privilege> getPrivilegesByRoleid(Long rid);
	public Collection<Privilege> getMenuitemTreeByUid(Long uid);
	public Collection<Privilege> getFunctionTreeByUid(Long uid);
}
