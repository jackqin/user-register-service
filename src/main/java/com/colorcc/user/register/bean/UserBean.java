package com.colorcc.user.register.bean;

import javax.xml.bind.annotation.XmlRootElement;

import com.colorcc.common.annotation.ColorccMarshalAnnotation;

@XmlRootElement
@ColorccMarshalAnnotation("userBean")
public class UserBean {

	private Long id;
	private String username;
	private String email;
	private String registerDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(String registerDate) {
		this.registerDate = registerDate;
	}

}
