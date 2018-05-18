package com.tj.gyl.query.basedata;

import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.tj.gyl.query.BaseQuery;
 
public class UserQuery extends BaseQuery{
	private String username;
	private String email;
	
	@Override
	public Map<String, Object> buildWhere() {
		if(StringUtils.isNotBlank(this.username)){
			this.getKeyValues().put("username", this.username);
		}
		if(StringUtils.isNotBlank(this.email)){
			this.getKeyValues().put("email", this.email);
		}
		return this.getKeyValues();
	}
	
}
