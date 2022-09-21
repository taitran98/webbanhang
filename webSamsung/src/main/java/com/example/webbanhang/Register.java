package com.example.webbanhang;

import java.sql.Date;
import javax.validation.constraints.*;

public class Register {
	 private int id;
	 private String name;

	 @NotBlank(message = "Bạn cần nhập mật khẩu!")
	 @Size(min =8,max=15, message = "Nhập mật khẩu từ 5-18 ký tự!")
	 private String pass;

	 private Date dob;
	 private int gender;
	 private String address;
	 private String district;
	 private String city;

	 @NotBlank(message = "Bạn cần nhập email !")
	 @Email(message = "Bạn hãy nhập địa chỉ email hợp lệ !")
	 private String email;
	 
	 private int phone;
	 private int active;
	 
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public int getActive() {
		return active;
	}
	public void setActive(int active) {
		this.active = active;
	}
}
