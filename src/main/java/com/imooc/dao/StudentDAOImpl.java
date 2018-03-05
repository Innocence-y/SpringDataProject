package com.imooc.dao;

import com.imooc.domain.Student;
import com.imooc.util.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:实现类
 * StudentDAO访问接口实现类，通过最原始的JDBC的方式操作
 * @author 闫文强
 * @create 2018-03-05 22:10
 */
public class StudentDAOImpl implements StudentDAO {

	/**
	 * 查询所有学生
	 *
	 * @return
	 */

	public List<Student> query() {
		List<Student> students=new ArrayList<Student>();
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql="select id, name, age from student";
		try {
			connection= JDBCUtil.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			resultSet=preparedStatement.executeQuery();
			while (resultSet.next()){
				int id = resultSet.getInt("id");
				String name= resultSet.getString("name");
				int age = resultSet.getInt("age");
				Student student=new Student();
				student.setId(id);
				student.setName(name);
				student.setAge(age);
				students.add(student);
			}
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtil.release(resultSet,preparedStatement,connection);
		}
		return students;
	}


	public void save(Student student) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql="insert into student(name, age) values(?, ?) ";
		try {
			connection= JDBCUtil.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1,student.getName());
			preparedStatement.setInt(2,student.getAge());
			preparedStatement.executeUpdate();
		} catch (Exception e){
			e.printStackTrace();
		} finally {
			JDBCUtil.release(resultSet,preparedStatement,connection);
		}
	}
}
