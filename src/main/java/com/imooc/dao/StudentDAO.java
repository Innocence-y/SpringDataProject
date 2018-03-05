package com.imooc.dao;

import com.imooc.domain.Student;

import java.util.List;

public interface StudentDAO {
	/**
	 * 查询所有学生
	 * @return
	 */
	public List<Student> query();

	public void save(Student student);
}
