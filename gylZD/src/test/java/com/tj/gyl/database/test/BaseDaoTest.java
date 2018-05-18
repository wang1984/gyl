package com.tj.gyl.database.test;

import org.junit.Test;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.query.basedata.DepartmentQuery;
import com.tj.gyl.test.utils.SpringUtils;

public class BaseDaoTest extends SpringUtils{
	/**
	 * 给 baseDaoImpl添加注解 @Repository("baseDao")
	 * 方便测试baseDao.getCount()方法 
	 */
	@Test
	public void testBaseDao_Count(){
		BaseDao baseDao = (BaseDao)context.getBean("baseDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		baseQuery.setName("财务部");
		int count = baseDao.getCount(baseQuery);
		System.out.println(count);
	}
}
