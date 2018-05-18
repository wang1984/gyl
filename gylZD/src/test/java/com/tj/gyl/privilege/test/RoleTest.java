package com.tj.gyl.privilege.test;

import org.junit.Test;

import com.tj.gyl.domain.privilege.Role;
import com.tj.gyl.privilege.dao.RoleDao;
import com.tj.gyl.privilege.service.RoleService;
import com.tj.gyl.test.utils.SpringUtils;

 
public class RoleTest extends SpringUtils{
	@Test
	public void testSaveRole(){
		RoleService roleService = (RoleService)context.getBean("roleService");
		Role t = new Role();
		t.setIsParent(true);
		t.setName("CEO");
		t.setPid(0L);
		roleService.saveEntry(t);
	}
	
	@Test
	public void testQueryRoleByName(){
		RoleDao roleDao = (RoleDao)context.getBean("roleDao");
		Role role = roleDao.getRoleByName("aaa");
		System.out.println(role);
	}
}
