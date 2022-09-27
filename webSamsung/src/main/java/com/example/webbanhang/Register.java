package com.example.webbanhang;

import java.sql.Date;
import javax.validation.constraints.*;



public class Register {

	private String name;

	@NotBlank(message = "Nhập mật khẩu!")
	@Size(min = 8, max = 15, message = "Mật khẩu từ 8-15 ký tự")
	private String pass;

	@NotBlank(message = "Nhập lại mật khẩu!")
	@Size(min = 8, max = 15, message = "Mật khẩu từ 8-15 ký tự")
	private String confirmpass;

	private Date dob;
	
	private String gender;

	private String address;

	private String district;

	private String city;

	@NotBlank(message = "Nhập email!")
	@Email(message = "Bạn hãy nhập địa chỉ email hợp lệ !")
	private String email;

	private String phone;

	private int active;

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

	public String getConfirmpass() {
		return confirmpass;
	}

	public void setConfirmpass(String confirmpass) {
		this.confirmpass = confirmpass;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}
}
