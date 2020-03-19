package com.management.student.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;

import com.management.student.model.Student;

public interface StudentMapper {

	@Select({
		"CALL SP_Student_Create("
				+"#{errorCode,mode=OUT,jdbcType=INTEGER},"
				+"#{errorMessage,mode=OUT,jdbcType=VARCHAR},"
				+"#{studentID,mode=IN,jdbcType=INTEGER},"
				+"#{name,mode=IN,jdbcType=VARCHAR},"
				+"#{address,mode=IN,jdbcType=VARCHAR},"
				+"#{phone,mode=IN,jdbcType=VARCHAR},"
				+"#{sex,mode=IN,jdbcType=VARCHAR},"
				+"#{remarks,mode=IN,jdbcType=VARCHAR})"
	})
	@Options(statementType=StatementType.CALLABLE)
	@Results({
		@Result(column = "id", property = "ID"),
		@Result(column = "student_id", property = "studentID"),
		@Result(column = "student_name", property = "name"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "sex", property = "sex"),
		@Result(column = "remarks", property = "remarks")
	})
	public Student createEx(Map<String, Object> params);
	
	/** 添加学生，返回id*/
	@Insert("INSERT INTO student(id, student_id, student_name, address, phone, sex, remarks) VALUES(#{ID}, #{studentID}, #{name}, #{address}, #{phone}, #{sex}, #{remarks})")
	@Options(useGeneratedKeys=true, keyProperty="ID",keyColumn="id")
	public int create(Student student);
	
	/** 修改学生，返回id*/
	@Update("UPDATE student SET student_id = #{studentID}, student_name = #{name}, address = #{address}, phone = #{phone}, sex = #{sex}, remarks = #{remarks} WHERE id = #{ID}")
	@Options(useGeneratedKeys=true, keyProperty="ID",keyColumn="id")
	public int update(Student student);
	
	/** 删除学生，什么都不返回*/
	@Delete("DELETE FROM student WHERE id = #{ID}")
	public void delete(int ID);
	
	/** 查询所有学生信息，载入页面时调用*/
	@Select("SELECT * FROM student")
	@Results({
		@Result(column = "id", property = "ID"),
		@Result(column = "student_id", property = "studentID"),
		@Result(column = "student_name", property = "name"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "sex", property = "sex"),
		@Result(column = "remarks", property = "remarks")
	})
	public List<Student> retrieveAll(Student student);

	/** 根据ID查询学生，修改学生前需要调用*/
	@Select("SELECT * FROM student where id = #{ID}")
	@Results({
		@Result(column = "id", property = "ID"),
		@Result(column = "student_id", property = "studentID"),
		@Result(column = "student_name", property = "name"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "sex", property = "sex"),
		@Result(column = "remarks", property = "remarks")
	})
	public List<Student> retrieve1(Student student);
	
	/** 根据关键词模糊查询学生*/
	@Select("SELECT * FROM student where student_id like '${queryKeyWord}' or student_name like '%${queryKeyWord}%' or phone like '%${queryKeyWord}%'")
	@Results({
		@Result(column = "id", property = "ID"),
		@Result(column = "student_id", property = "studentID"),
		@Result(column = "student_name", property = "name"),
		@Result(column = "address", property = "address"),
		@Result(column = "phone", property = "phone"),
		@Result(column = "sex", property = "sex"),
		@Result(column = "remarks", property = "remarks")
	})
	public List<Student> retrieveByQueryKeyWord(String queryKeyWord);
}
