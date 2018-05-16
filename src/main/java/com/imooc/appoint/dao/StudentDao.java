package com.imooc.appoint.dao;

import org.apache.ibatis.annotations.Param;

import com.imooc.appoint.entiy.Student;

public interface StudentDao {
	/**
	 * 向数据库验证输入的密码是否正确
	 */
	Student quaryStudent(@Param("studentId") long studentId, @Param("password") long password);
}
