package com.tj.gyl.basedata.action;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tj.gyl.base.action.BaseAction;
import com.tj.gyl.basedata.service.DepartmentService;
import com.tj.gyl.domain.basedata.Department;
import com.tj.gyl.privilege.annotation.PrivilegeInfo;
import com.tj.gyl.query.PageResult;
import com.tj.gyl.query.basedata.DepartmentQuery;

@Controller("departmentAction")
@Scope("prototype")
public class DepartmentAction extends BaseAction<Department>{
	@Resource(name="departmentService")
	private DepartmentService departmentService;
	private DepartmentQuery baseQuery = new DepartmentQuery();
	
	 
	@PrivilegeInfo(name="部门查询")
	public String showPageResult(){
		baseQuery.setCurrentPage(this.getCurrentPage());
		PageResult<Department> departments = this.departmentService.getPageResult(baseQuery);
		ActionContext.getContext().put("departments", departments);
		return listAction;
	}
	
	
	public String deleteDepartments(){
		/**
		 * 如果页面上的删除采用<input type="button" value="删除">这种形式
		 */
		//String[] ids = this.getCheckedStr().split(",");
		//this.departmentService.deleteEntriesByIds(ids);
		/**
		 * 如果页面上的删除采用<input type="submit" value="删除">这种形式
		 */ 
		this.departmentService.deleteEntriesByIds(this.getIds());
		return action2action;
	}
	//添加链接
	public String addUI(){
		return addUI;
	}
	//添加动作
	public String add(){
		Department department = new Department();
		//把的 this.getModel() 值拷贝给  department
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.saveEntry(department);
		return action2action;
	}
	
	public String updateUI(){
		Department department = this.departmentService.getEntryById(this.getModel().getDid());
		ActionContext.getContext().getValueStack().push(department);
		return updateUI;
	}
	
	public String update(){
		Department department = this.departmentService.getEntryById(this.getModel().getDid());
		BeanUtils.copyProperties(this.getModel(), department);
		this.departmentService.updateEntry(department);
		return "chain";
	}
}