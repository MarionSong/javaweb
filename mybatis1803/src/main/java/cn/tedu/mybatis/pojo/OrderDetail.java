package cn.tedu.mybatis.pojo;

public class OrderDetail {
	private Integer id;
	private Integer num;
	private String item;
	private Double price;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "OrderDetail [id=" + id + ", num=" + num + ", item=" + item + ", price=" + price + "]";
	}
	
	
	
}
