package com.management.student.model;

import java.util.HashMap;
import java.util.Map;

public class Student {
	private int ID;
	
	private int studentID;
	
	private String name;
	
	private String address;
	
	private String phone;
	
	private String sex;
	
	private String remarks;
	
	private String queryKeyWord;
	
	public String getQueryKeyWord() {
		return queryKeyWord;
	}

	public void setQueryKeyWord(String queryKeyWord) {
		this.queryKeyWord = queryKeyWord;
	}

	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public int getStudentID() {
		return studentID;
	}
	
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getSex() {
		return sex;
	}
	
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getRemarks() {
		return remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "Student [ID=" + ID + ", studentID=" + studentID + ", name=" + name + ", address=" + address + ", phone="
				+ phone + ", sex=" + sex + ", remarks=" + remarks + "]";
	}
	
	public Map<String, Object> getCreateParams(Student student){
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("studentID", student.getStudentID());
		params.put("name", student.getName());
		params.put("address", student.getAddress());
		params.put("phone", student.getPhone());
		params.put("sex", student.getSex());
		params.put("remarks", student.getRemarks());
		return params;
		
	}
	
	public String checkCreate() {
		
		return "";
	}
	
	public String checkUpdate() {
		
		return "";
	}
}
