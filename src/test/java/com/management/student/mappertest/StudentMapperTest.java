package com.management.student.mappertest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.Random;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.management.student.StudentApplication;
import com.management.student.mapper.StudentMapper;
import com.management.student.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { StudentApplication.class })
public class StudentMapperTest {

	@Resource
	private StudentMapper studentMapper;

	@Before
	public void setup() {
		System.out.println("---------------------测试开始------------------------");
	}

	@After
	public void tearDown() {
		System.out.println("---------------------测试结束------------------------");
	}

	@Test
	public void testCreate() {
		Student student = getStudentToCreate();
		int ifSuccess = studentMapper.create(student);
		System.out.println(ifSuccess);
		assertTrue(ifSuccess == 1, "testCreate创建失败！");
	}

	@Test
	public void testCreateEx() {
		Student student = getStudentToCreate();
		Map<String, Object> params = student.getCreateParams(student);
		Student ifSuccess = studentMapper.createEx(params);
		assertTrue(ifSuccess != null && "1".equals(params.get("errorCode").toString()),
				"testCreateEx创建失败！errorMsg=" + params.get("errorMessage").toString());
	}

	private Student getStudentToCreate() {
		Student student = new Student();
		student.setAddress("广东省" + System.currentTimeMillis() % 100000);
		student.setName("LLL" + System.currentTimeMillis() % 10000);
		student.setPhone(String.valueOf(System.currentTimeMillis()).substring(0, 11));
		student.setRemarks("remarks" + System.currentTimeMillis() % 100000);
		student.setSex((new Random().nextInt(4)) % 2 > 0 ? "男" : "女");
		student.setStudentID(
				Integer.valueOf(String.valueOf(new Random().nextInt(6)) + String.valueOf(new Random().nextInt(16))));
		return student;
	}
}
