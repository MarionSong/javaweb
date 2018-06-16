package com.songming.mybatis616.pojo;

import java.util.Date;

public class User {
	private Integer id;
	private String name;
	private Date birthday;
	private String address;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String toString() {
		return "User[id="+id+",name="+name+",birthday="+birthday+",adderss="+address+"]";
		
		
	}
}
