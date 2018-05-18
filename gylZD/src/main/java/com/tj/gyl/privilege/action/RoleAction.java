package com.tj.gyl.privilege.action;

import java.util.Collection;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.tj.gyl.base.action.BaseAction;
import com.tj.gyl.basedata.service.UserService;
import com.tj.gyl.domain.basedata.User;
import com.tj.gyl.domain.privilege.Privilege;
import com.tj.gyl.domain.privilege.Role;
import com.tj.gyl.privilege.service.RoleService;
import com.tj.gyl.utils.GylConstantKey;

 

@Controller("roleAction")
@Scope("prototype")
public class RoleAction extends BaseAction<Role>{
	@Resource(name="roleService")
	private RoleService roleService;
	
	@Resource(name="userService")
	private UserService userService;
	
	private Long uid;//用户id   根据该用户id根据该用户能够访问到的角色
	
	private String checkedStr;
	
	
	
	public String getCheckedStr() {
		return checkedStr;
	}

	public void setCheckedStr(String checkedStr) {
		this.checkedStr = checkedStr;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	public String showRoleTree(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	
	/**
	 * 在权限管理-->角色配置-->设置角色(超级链接)-->加载角色树，涉及到对角色树的回显
	 * @return
	 */
	public String showRoleByUid(){
		Collection<Role> roles = this.roleService.getRoleByUid(uid);
		ActionContext.getContext().getValueStack().push(roles);
		return SUCCESS;
	}
	
	public String add(){
		Role role = new Role();
		BeanUtils.copyProperties(this.getModel(), role);
		this.roleService.saveEntry(role);
		/**
		 * 把role回调到客户端，因为客户端要使用rid
		 */
		ActionContext.getContext().getValueStack().push(role);
		return SUCCESS;
	}
	
	public String showRoleByName(){
		Role role = this.roleService.getRoleByName(this.getModel().getName());
		if(role==null){//说明页面上的name的值可用
			ActionContext.getContext().getValueStack().push(GylConstantKey.ROLE_NAME_FLAG_ABLE);// 设置标志位传递到客户端，表示name的值可用
		}else{
			ActionContext.getContext().getValueStack().push(GylConstantKey.ROLE_NAME_FLAG_DISABLE);// 设置标志位传递到客户端，表示name的值可用
		}
		return SUCCESS;
	}
	
	public String deleteRole(){
		this.roleService.deleteEntryById(this.getModel().getRid());
		return SUCCESS;
	}
	
	public String updateRole(){
		Role role = this.roleService.getEntryById(this.getModel().getRid());
		//仅修改名称就可以了
		role.setName(this.getModel().getName());
		this.roleService.updateEntry(role);
		return SUCCESS;
	}
	
	/**
	 * 在权限管理-->权限配置-->打开角色设置权限的页面的时候，显示角色列表，用该方法
	 */
	public String showRoles(){
		Collection<Role> roles = this.roleService.getEntries();
		ActionContext.getContext().put("roles", roles);
		return listAction;
	}
	
	/**
	 * 跳转到用户设置角色的页面
	 */
	public String showUserList(){
		Collection<User> users = this.userService.getEntries();
		ActionContext.getContext().put("users", users);
		return listAction;
	}
	
	/**
	 * 建立用户与角色之间的关系
	 */
	public String saveRole(){
		User user = this.userService.getEntryById(uid);
        //获取到被选中的角色的集合
		if("".equals(this.checkedStr)){//页面上没有选择角色
			user.setRoles(null);
		}else{
			Set<Role> roles = this.roleService.getEntriesByIds(this.checkedStr.split(","));
			user.setRoles(roles);//建立用户与角色之间的关系
		}
		 
		this.userService.updateEntry(user);
		return SUCCESS;
		
		 
		
	}
}
