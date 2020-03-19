package com.management.student.action;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.management.student.model.Student;
import com.management.student.services.StudentServices;

@Controller
@RequestMapping("/student")
public class StudentAction {

	@Resource
	private StudentServices studentServices;

	@PostMapping("createEx")
	public String createEx(ModelMap model, Student student, HttpSession session) {

		String stu = studentServices.createStudent(student);
		if (!stu.equals("")) {
			model.addAttribute("errorMsg", stu);
			return "addStudent.html";
		}
		return "redirect:/student/retrieveNEx";
	}

	@RequestMapping("editStudent")
	public String editStudent(ModelMap model, Student student, HttpServletRequest request) {
		int ID = Integer.valueOf(request.getParameter("id"));
		student.setID(ID);
		List<Student> studentList = studentServices.retrieveStudents(student, 2);
		Student studentEdit = studentList.get(0);
		model.addAttribute("student", studentEdit);
		return "updateStudent.html";
	}

	@RequestMapping("updateEx")
	public String updateEx(ModelMap model, Student student, HttpSession session) {

		String stu = studentServices.updateStudent(student);
		if (!stu.equals("")) {
			model.addAttribute("errorMsg", stu);
			return "forward:/updateStudent.html";
		}
		return "redirect:/student/retrieveNEx";
	}

	@RequestMapping("retrieveNEx")
	public String retrieveNEx(ModelMap model, Student student, HttpSession session) {
		List<Student> studentList = studentServices.retrieveStudents(student, 0);
		model.addAttribute("studentList", studentList);
		return "students.html";
	}

	@RequestMapping("queryStudent")
	public String queryStudent(ModelMap model, Student student, HttpServletRequest request) {
		student.setQueryKeyWord(request.getParameter("queryKeyWord"));
		List<Student> studentList = studentServices.retrieveStudents(student, 1);
		model.addAttribute("studentList", studentList);
		return "students.html";
	}

	@RequestMapping("deleteEx")
	public String deleteEx(HttpServletRequest request) {
		int ID = Integer.valueOf(request.getParameter("id"));
		studentServices.deleteStudent(ID);
		return "redirect:/student/retrieveNEx";
	}
}
