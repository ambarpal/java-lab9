package com.Pizza.models;

public class User {
	String name;
	String contact;
	String address;
	Integer uid;
	String order;
	String orderStatus;
	public User(String name, String contact, String address, Integer uid, String order) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.uid = uid;
		this.order = order;
	}
	public void incrementOrderStatus(){
		if (this.orderStatus.equals("Order Placed")) this.orderStatus = "Preparation";
		else if (this.orderStatus.equals("Preparation")) this.orderStatus = "Bake";
		else if (this.orderStatus.equals("Bake")) this.orderStatus = "Quality Check";
		else if (this.orderStatus.equals("Quality Check")) this.orderStatus = "Out for Delivery";
		else if (this.orderStatus.equals("Out for Delivery")) this.orderStatus = "Delivered";
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getName() {
		return name;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
