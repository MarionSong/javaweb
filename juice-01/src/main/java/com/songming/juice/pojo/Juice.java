package com.songming.juice.pojo;

public class Juice {
	private Integer id;
	private String fruit;
	private String size;
	private String sugar;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFruit() {
		return fruit;
	}
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getSugar() {
		return sugar;
	}
	public void setSugar(String sugar) {
		this.sugar = sugar;
	}
	
	public String toString() {
		return "id="+id+",fruit="+fruit+",size="+size+",sugar="+sugar;
			
		
	}
	
	
	
	
}
