package com.yc.po;

public class StudentPO {
private String uname;
private String pwd;
private Integer age;
private AddressPO addr;
public AddressPO getAddr() {
	return addr;
}
public void setAddr(AddressPO addr) {
	this.addr = addr;
}

@Override
public String toString() {
	return "StudentPO [uname=" + uname + ", pwd=" + pwd + ", age=" + age + ", addr=" + addr + "]";
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPwd() {
	return pwd;
}
public void setPwd(String pwd) {
	this.pwd = pwd;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
}
