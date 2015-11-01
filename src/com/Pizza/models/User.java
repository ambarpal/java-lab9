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
