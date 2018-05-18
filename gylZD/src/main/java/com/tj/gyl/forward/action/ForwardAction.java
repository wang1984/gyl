package com.tj.gyl.forward.action;

import com.opensymphony.xwork2.ActionSupport;

public class ForwardAction extends ActionSupport{
	
	private String method;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}
	
	public String forward(){
		System.out.println( this.method);
		return this.method;
	}
}
