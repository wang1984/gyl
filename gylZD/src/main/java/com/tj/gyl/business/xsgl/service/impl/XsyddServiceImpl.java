package com.tj.gyl.business.xsgl.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.tj.gyl.base.dao.BaseDao;
import com.tj.gyl.business.base.service.impl.BaseBusinessServiceImpl;
import com.tj.gyl.business.xsgl.dao.XsyddzhibDao;
import com.tj.gyl.business.xsgl.dao.XsyddzhubDao;
import com.tj.gyl.business.xsgl.service.XsyddService;
import com.tj.gyl.domain.business.xsgl.Xsyddzhib;
import com.tj.gyl.domain.business.xsgl.Xsyddzhub;

@Service("xsyddService")
public class XsyddServiceImpl extends BaseBusinessServiceImpl<Xsyddzhub, Xsyddzhib> implements XsyddService{
	@Resource(name="xsyddzhubDao")
	private XsyddzhubDao xsyddzhubDao;
	
	@Resource(name="xsyddzhibDao")
	private XsyddzhibDao xsyddzhibDao;
	
	@Override
	public BaseDao<Xsyddzhub> getBaseDao_zhu() {
		 
		return this.xsyddzhubDao;
	}
	
	@Override
	public BaseDao<Xsyddzhib> getBaseDao_zhi() {
		 
		return this.xsyddzhibDao;
	}
}
