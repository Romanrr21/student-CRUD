package com.project.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.student.model.Student;
import com.project.student.service.StudentServiceImpl;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentServiceImpl studentService;

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public long add(@RequestBody Student student) {
		System.out.println(student);
		long studentId = studentService.addstudent(student);
		return studentId;
	}

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getAllStudents() {
		List<Student> studentList = studentService.getAllStudents();
		return studentList;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student getStudentById(@PathVariable long id) {
		Student student = studentService.getStudentById(id);
		return student;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/grade/lt/{grade}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> getStudentGradelesserThan(@PathVariable int grade) {
		List<Student> studentList = studentService.getStudentGradelesserThan(grade);
		return studentList;
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	public void deleteById(@PathVariable long id) {
		studentService.deleteById(id);

	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Student updateStudent(@RequestBody Student student) {
		Student updatedStudent = studentService.updatestudent(student);
		return updatedStudent;
	}
}
