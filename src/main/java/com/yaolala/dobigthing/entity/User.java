package com.yaolala.dobigthing.entity;
/**
 * 实体类
 * @author liaoxiaojin
 *
 */
public class User {
	private int id;
	private int age;
	private String name;
	private String pwd;
	public int getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User(int id,String name,String pwd){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public User(int id, int age, String name) {
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public User() {
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", age=" + age + ", name=" + name + ", pwd =" + pwd;
	}
	
	
	
}
