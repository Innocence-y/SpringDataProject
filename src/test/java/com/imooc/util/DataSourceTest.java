package com.imooc.util;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 描述:测试类
 *
 * @author 闫文强
 * @create 2018-03-05 22:59
 */
public class DataSourceTest {
	private ApplicationContext ctx = null;

	@Before
	public  void  setup(){
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("setup");
	}

	@Test
	public  void  testDataSource(){
		System.out.println("testDataSource");
		DataSource dataSource= (DataSource) ctx.getBean("dataSource");
		Assert.assertNotNull(dataSource);
	}

	@After
	public  void tearDown(){
		ctx= null;
		System.out.println("tearDown");
	}

	@Test
	public  void  testJdbcTemplate(){
		System.out.println("testJdbcTemplate");
		JdbcTemplate jdbcTemplate= (JdbcTemplate) ctx.getBean("jdbcTemplate");
		Assert.assertNotNull(jdbcTemplate);
	}
}