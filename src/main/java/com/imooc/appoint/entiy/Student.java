package com.imooc.appoint.entiy;

public class Student {  
	private Long studentId;
	private Long password;
	
	public Student(){
		
	}
	public Student(Long studentId,Long password){
		this.studentId=studentId;
		this.password=password;
	}
	public Long getStudentId() {
		return studentId;
	}
	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}
	public Long getPassword() {
		return password;
	}
	public void setPassword(Long password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", password=" + password + "]";
	}
}
