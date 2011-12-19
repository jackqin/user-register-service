package com.colorcc.user.register.dto;

import com.colorcc.common.utils.DateUtil;
import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.model.User;

public class UserToBeanDto implements BaseDto<User, UserBean> {
	
	@Override
	public UserBean transferTtoBean(User user) {
		if (user == null) {
			return null;
		}

		UserBean userBean = new UserBean();
		userBean.setId(user.getId());
		userBean.setEmail(user.getEmail());
		userBean.setUsername("User : " + user.getEmail());
		userBean.setRegisterDate(DateUtil.getInstances().getDate(user.getCreateTime()));

		return userBean;
	}

}
