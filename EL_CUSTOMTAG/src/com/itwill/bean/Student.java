package com.itwill.bean;

public class Student {
	private int no;
	private String name;
	private int age;
	private Car car;
	
	public Student() {
		
	}
	
	public Student(int no, String name, int age, Car car) {
		super();
		this.no = no;
		this.name = name;
		this.age = age;
		this.car = car;
	}

	public int getNo() {
		return no;
	}

	public String getIrum() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setIrum(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}
	
	
	/*
	 no, irum, age 프로퍼티를 가진다(read property)
	 no, irum, age 프로퍼티를 가진다(write property)
	 
	Student Bean객체는  read, write가능한 no, irum, age 프로퍼티를 가진다
	 */
}
