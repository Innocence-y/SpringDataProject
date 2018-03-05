package com.imooc.dao;

import com.imooc.domain.Student;
import org.junit.Test;

import java.util.List;

/**
 * 描述:
 *
 * @author 闫文强
 * @create 2018-03-05 22:25
 */
public class StudentDAOImplTest {

	@Test
	public void  testQuery(){
		StudentDAO studentDAO=new StudentDAOImpl();
		List<Student> students=studentDAO.query();
		for (Student student : students) {
			System.out.println(student.toString());
		}
	}

	@Test
	public void testSave(){
		StudentDAO studentDAO=new StudentDAOImpl();
		Student student=new Student();
		student.setName("test");
		student.setAge(30);
		studentDAO.save(student);
	}
}