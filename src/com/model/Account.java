package com.model;

public class Account {
private int custId;
private int accId;
private String accType;
private double balance;
private String crdate;
private String crlastdate;
private String status;
private String message;
private String lastup;
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
public String getLastup() {
	return lastup;
}
public void setLastup(String lastup) {
	this.lastup = lastup;
}
//private int duration;
public Account(int custId, int accId, String accType, double balance, String crdate, String crlastdate) {
	super();
	this.custId = custId;
	this.accId = accId;
	this.accType = accType;
	this.balance = balance;
	this.crdate = crdate;
	this.crlastdate = crlastdate;
	//this.duration = duration;
}
public Account() {
	super();
}
public int getCustId() {
	return custId;
}
public void setCustId(int custId) {
	this.custId = custId;
}
public int getAccId() {
	return accId;
}
public void setAccId(int accId) {
	this.accId = accId;
}
public String getAccType() {
	return accType;
}
public void setAccType(String accType) {
	this.accType = accType;
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public String getCrdate() {
	return crdate;
}
public void setCrdate(String crdate) {
	this.crdate = crdate;
}
public String getCrlastdate() {
	return crlastdate;
}
public void setCrlastdate(String crlastdate) {
	this.crlastdate = crlastdate;
}
//public int getDuration() {
//	return duration;
//}
//public void setDuration(int duration) {
	//this.duration = duration;
//}
//@Override
/*public String toString() {
	return "Account [custId=" + custId + ", accId=" + accId + ", accType=" + accType + ", balance=" + balance
			+ ", crdate=" + crdate + ", crlastdate=" + crlastdate + " + "]";
}*/


}
