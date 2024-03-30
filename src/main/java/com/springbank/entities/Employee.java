package com.springbank.entities;

public class Employee {
	private int pinNum;
	private String name;
	private int amount;
	public int getPinNum() {
		return pinNum;
	}
	public void setPinNum(int pinNum) {
		this.pinNum = pinNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public Employee(int pinNum, String name, int amount) {
		super();
		this.pinNum = pinNum;
		this.name = name;
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Employee [pinNum=" + pinNum + ", name=" + name + ", amount=" + amount + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
