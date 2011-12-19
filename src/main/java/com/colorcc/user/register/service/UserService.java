package com.colorcc.user.register.service;

import java.util.List;

import com.colorcc.user.register.bean.UserBean;

public interface UserService {
	public UserBean getUser(Long id);

	public List<UserBean> getUserList(Long startRow, int fetchRows);
}
