package com.tj.gyl.database.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;

import com.tj.gyl.test.utils.SpringUtils;

public class SessionFactoryTest extends SpringUtils {
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		System.out.println(sessionFactory);
	}
	
	//测试  count(*) 是否可以用
	@Test
	public void testCountProduct(){
		SessionFactory sessionFactory = (SessionFactory)context.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Long count = (Long)session.createQuery("select count(*) from Department").uniqueResult();
		System.out.println(count);
		session.close();
	}
}
