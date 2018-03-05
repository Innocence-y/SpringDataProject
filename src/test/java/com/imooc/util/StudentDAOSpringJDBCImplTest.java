package com.imooc.util;

import com.imooc.dao.StudentDAO;
import com.imooc.domain.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * 描述:测试类
 *
 * @author 闫文强
 * @create 2018-03-05 22:59
 */
public class StudentDAOSpringJDBCImplTest {
	private ApplicationContext ctx = null;
	private StudentDAO studentDAO= null;

	@Before
	public  void  setup(){
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		studentDAO = (StudentDAO) ctx.getBean("studentDAO");
		System.out.println("setup");
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

	@Test
	public void  testQuery(){
		List<Student> students=studentDAO.query();

		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	@Test
	public void testSave(){

		Student student=new Student();
		student.setName("test-spring-jdbc");
		student.setAge(40);
		studentDAO.save(student);
	}
}