package com.tj.gyl.basedata.dao.impl;

import org.springframework.stereotype.Repository;

import com.tj.gyl.base.dao.impl.BaseDaoImpl;
import com.tj.gyl.basedata.dao.DepartmentDao;
import com.tj.gyl.domain.basedata.Department;

@Repository("departmentDao")
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao{

}