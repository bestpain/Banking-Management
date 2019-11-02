package com.model;

public class Customer {
	private int SSN;
	private int custId;
	private String name;
	private int age;
	private String address;
	private String city;
	private String state;
	private String status;
	private String message;
	private String lastupdate;
	
	public Customer(int sSN, int custId, String name, int age, String address, String city, String state) {
		super();
		SSN = sSN;
		this.custId = custId;
		this.name = name;
		this.age = age;
		this.address = address;
		this.city = city;
		this.state = state;
	}
	public Customer() {
		super();
	}
	public int getSSN() {
		return SSN;
	}
	public void setSSN(int sSN) {
		SSN = sSN;
	}
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getLastupdate() {
		return lastupdate;
	}
	public void setLastupdate(String lastupdate) {
		this.lastupdate = lastupdate;
	}
	@Override
	public String toString() {
		return "Customer [SSN=" + SSN + ", custId=" + custId + ", name=" + name + ", age=" + age + ", address="
				+ address + ", city=" + city + ", state=" + state + "]";
	}
	

}
