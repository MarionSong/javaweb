package cn.tedu.mybatis.pojo;

import java.util.Date;
import java.util.List;

public class Order {
	private  Door door;
	private List<OrderDetail> orderDetails;
	
	
	private Integer id;
	private String orderNo;
	private String orderType;
	private Integer personNum;
	private String cashier;
	private Date createTime;
	private Date endTime;
	private String paymentType;
	private Double price;
	public Door getDoor() {
		return door;
	}
	public void setDoor(Door door) {
		this.door = door;
	}
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public Integer getPersonNum() {
		return personNum;
	}
	public void setPersonNum(Integer personNum) {
		this.personNum = personNum;
	}
	public String getCashier() {
		return cashier;
	}
	public void setCashier(String cashier) {
		this.cashier = cashier;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Order [door=" + door + ", orderDetails=" + orderDetails + ", id=" + id + ", orderNo=" + orderNo
				+ ", orderType=" + orderType + ", personNum=" + personNum + ", cashier=" + cashier + ", createTime="
				+ createTime + ", endTime=" + endTime + ", paymentType=" + paymentType + ", price=" + price + "]";
	}
	
	
}
