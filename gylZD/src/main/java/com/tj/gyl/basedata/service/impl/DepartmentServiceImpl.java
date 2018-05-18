package com.tj.gyl.basedata.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.base.service.impl.BaseServiceImpl;
import com.tj.gyl.basedata.dao.DepartmentDao;
import com.tj.gyl.basedata.service.DepartmentService;
import com.tj.gyl.domain.basedata.Department;

 
@Service("departmentService")
public class DepartmentServiceImpl extends  BaseServiceImpl<Department> implements DepartmentService{
	@Resource(name="departmentDao")
	private DepartmentDao departmentDao;
	
	@Override
	public BaseDao getBaseDao() {
		
		return this.departmentDao;
	}	
}