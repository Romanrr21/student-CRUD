package com.project.student.service;

import java.util.List;

import com.project.student.model.Student;

public interface StudentService {
	public long addstudent(Student student);
	public List<Student> getAllStudents();
	public Student getStudentById(long id);
	public List<Student> getStudentGradelesserThan(int grade);
	public void deleteById(long id);
	public Student updatestudent(Student student);
}
