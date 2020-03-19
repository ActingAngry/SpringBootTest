package com.management.student.services;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.management.student.mapper.StudentMapper;
import com.management.student.model.Student;

@Service
public class StudentServicesImpl implements StudentServices {

	@Resource
	private StudentMapper studentMapper;

	@Override
	public String createStudent(Student student) {
		if (false) { // checkcreate
			return null;
		}
		Map<String, Object> params = student.getCreateParams(student);
		studentMapper.createEx(params);

		return params.get("errorMessage").toString();
	}

	@Override
	public String updateStudent(Student student) {
		if (false) { // checkupdate
			return null;
		}
		int studentUpdate = studentMapper.update(student);
		return String.valueOf(studentUpdate);
	}

	@Override
	public List<Student> retrieveStudents(Student student, int caseID) {
		List<Student> listStudents = null;
		switch (caseID) {
		case 1:
			listStudents = studentMapper.retrieveByQueryKeyWord(student.getQueryKeyWord());
			break;
		case 2:
			listStudents = studentMapper.retrieve1(student);
			break;
		default:
			listStudents = studentMapper.retrieveAll(student);
			break;
		}
		return listStudents;
	}

	@Override
	public void deleteStudent(int ID) {
		studentMapper.delete(ID);

	}

}
