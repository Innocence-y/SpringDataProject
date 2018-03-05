package com.imooc.dao;

import com.imooc.domain.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCountCallbackHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:实现类
 * 通过SpringJDBC实现
 * @author 闫文强
 * @create 2018-03-05 23:21
 */
public class StudentDAOSpringJdbcImpl implements StudentDAO{

	/**
	 * 查询所有学生
	 *
	 * @return
	 */

	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Student> query() {
		final List<Student> students=new ArrayList<Student>();
		String sql = "select id, name, age from student";
		jdbcTemplate.query(sql, new RowCountCallbackHandler(){

			@Override
			protected void processRow(ResultSet rs, int rowNum) throws SQLException {
				int id =rs.getInt("id");
				String name=rs.getString("name");
				int age= rs.getInt("age");
				Student student=new Student();
				student.setAge(age);
				student.setName(name);
				student.setId(id);
				students.add(student);
			}
		});
		return students;
	}

	public void save(Student student) {
		String sql="insert into student(name, age) values(?, ?) ";
		jdbcTemplate.update(sql,new Object[]{student.getName(), student.getAge()});

	}
}