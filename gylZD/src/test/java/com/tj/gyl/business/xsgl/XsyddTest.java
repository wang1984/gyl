package com.tj.gyl.business.xsgl;

import org.junit.Test;

import com.tj.gyl.business.xsgl.service.XsyddService;
import com.tj.gyl.domain.business.xsgl.Xsyddzhib;
import com.tj.gyl.query.PageResult;
import com.tj.gyl.query.business.xsgl.XsyddzhibQuery;
import com.tj.gyl.test.utils.SpringUtils;

public class XsyddTest extends SpringUtils{
	@Test
	public void testQuery(){
		XsyddService xsyddService = (XsyddService)context.getBean("xsyddService");
 		
		/*XsyddzhubQuery baseQuery = new XsyddzhubQuery();
 		baseQuery.setKhmc("万达");
 	    baseQuery.setCurrentPage(1);
 	    PageResult<Xsyddzhub> pageResult_zhu = xsyddService.getEntrties_zhu(baseQuery);
 		System.out.println(pageResult_zhu.getRows().size());*/
		 
		XsyddzhibQuery xsyddzhibQuery = new XsyddzhibQuery();
	    xsyddzhibQuery.setXsyddzhubid(1L);
		xsyddzhibQuery.setCurrentPage(1);
		PageResult<Xsyddzhib> pageResult = xsyddService.getEntrties_zi(xsyddzhibQuery);
		System.out.println(pageResult.getRows().size());
	}
}
