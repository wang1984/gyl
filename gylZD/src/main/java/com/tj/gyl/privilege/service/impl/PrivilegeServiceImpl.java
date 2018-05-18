package com.tj.gyl.privilege.service.impl;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.base.service.impl.BaseServiceImpl;
import com.tj.gyl.domain.privilege.Privilege;
import com.tj.gyl.privilege.dao.PrivilegeDao;
import com.tj.gyl.privilege.service.PrivilegeService;
 

@Service("privilegeService")
public class PrivilegeServiceImpl extends BaseServiceImpl<Privilege> implements PrivilegeService{
	@Resource(name="privilegeDao")
	private PrivilegeDao privilegeDao;
	@Override
	public BaseDao getBaseDao() {
		 
		return this.privilegeDao;
	}
	@Override
	public Collection<Privilege> getPrivilegesByRoleid(Long rid) {
	 
		return this.privilegeDao.getPrivilegesByRid(rid);
	}
	@Override
	public Collection<Privilege> getMenuitemTreeByUid(Long uid) {

		return this.privilegeDao.getMenuitemTreeByUid(uid);
	}
	@Override
	public Collection<Privilege> getFunctionTreeByUid(Long uid) {
		
		return this.privilegeDao.getFunctionByUid(uid);
	}
}
