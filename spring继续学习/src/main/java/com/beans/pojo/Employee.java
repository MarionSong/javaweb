package com.beans.pojo;

public class Employee {
	private Integer id;
	private String name;
	private String category;
	private Double price;
	private Integer pnum;
	private String description;
	
	
	public Employee() {
		super();
	}


	public Employee(Integer id, String name, String category, Double price, Integer pnum, String description) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.pnum = pnum;
		this.description = description;
	}


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


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public Integer getPnum() {
		return pnum;
	}


	public void setPnum(Integer pnum) {
		this.pnum = pnum;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	public String toString() {
		return "id="+id+",name="+name+",category="+category+",price="+price+",pnum="+pnum+",description="+description+"";
				
	}
	
	
	
}
