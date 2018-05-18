package com.tj.gyl.database.test;

import org.junit.Test;

import com.tj.gyl.basedata.action.DepartmentAction;
import com.tj.gyl.basedata.dao.DepartmentDao;
import com.tj.gyl.basedata.service.DepartmentService;
import com.tj.gyl.domain.basedata.Department;
import com.tj.gyl.query.PageResult;
import com.tj.gyl.query.basedata.DepartmentQuery;
import com.tj.gyl.test.utils.SpringUtils;
/**
 * 测试 BaseDaoImpl类中的各种方法
 *
 */
public class DepartmentTest extends SpringUtils{
	@Test
	public void testGetCount(){
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		//baseQuery.setName("财务部");
		int count = departmentDao.getCount(baseQuery);
		System.out.println(count);
	}
	
	@Test
	public void testPageResult(){
		DepartmentDao departmentDao = (DepartmentDao)context.getBean("departmentDao");
		DepartmentQuery baseQuery = new DepartmentQuery();
		baseQuery.setCurrentPage(2);
		PageResult<Department> pageResult = departmentDao.findPageResult(baseQuery);
		for (Department department : pageResult.getRows()) {
			System.out.println(department.getDid());
		}
	}
	
	@Test
	public void testSaveDepartment(){
		DepartmentService departmentService = (DepartmentService)context.getBean("departmentService");
		Department t = new Department();
		t.setName("人事部");
		t.setDescription("公司人事部");
		departmentService.saveEntry(t);
	}
	
	 @Test
	public void testAction(){
		DepartmentAction departmentAction = (DepartmentAction)context.getBean("departmentAction");
	} 
	
}