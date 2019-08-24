package com.project.student.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.student.dao.StudentRepository;
import com.project.student.model.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public long addstudent(Student student) {

		System.out.println(" Iam in service");
		String originalName = student.getName();
		String modifiedName = "MR " + originalName;

		student.setName(modifiedName);

		Student s = studentRepository.save(student);

		long Id = s.getId();

		return Id;
	}

	@Override
	public List<Student> getAllStudents() {
		List<Student> studentList = studentRepository.findAll();
		return studentList;
	}

	@Override
	public Student getStudentById(long id) {
		Optional<Student> studentOptional = studentRepository.findById(id);
		return studentOptional.orElse(null);
	}

	@Override
	public List<Student> getStudentGradelesserThan(int grade) {

		List<Student> studentList = studentRepository.findAll();
		List<Student> finalList = new ArrayList<>();
		for (Student s : studentList) {
			if (s.getGrade() < grade) {
				finalList.add(s);
			}
		}

		// studentList.stream().filter( s -> s.getGrade() <
		// 2).collect(Collectors.toList());

		return finalList;
	}

	@Override
	public void deleteById(long id) {
		studentRepository.deleteById(id);

	}

	@Override
	public Student updatestudent(Student student) {
		long id = student.getId();
		Optional<Student> studentOptional = studentRepository.findById(id);
		Student existingStudent = studentOptional.get();

		String newName = student.getName();
		String newAddress = student.getAddress();
		int newGrade = student.getGrade();

		existingStudent.setName(newName);
		existingStudent.setAddress(newAddress);
		existingStudent.setGrade(newGrade);

		Student updatedStudent = studentRepository.save(existingStudent);

		return updatedStudent;
	}

}
