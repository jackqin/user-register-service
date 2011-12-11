package com.colorcc.user.register.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colorcc.common.utils.DateUtil;
import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.mapper.UserMapper;
import com.colorcc.user.register.model.User;
import com.colorcc.user.register.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;

	public UserBean getUser(Long id) {
		if (id == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("No user id equals null");
			}
			return null;
		}

		User user = userMapper.selectOne(id);
		UserBean userBean = new UserBean();
		if (user != null) {
			userBean.setId(user.getId());
			userBean.setEmail(user.getEmail());
			userBean.setUsername("User : " + user.getEmail());
			userBean.setRegisterDate(DateUtil.getInstances().getDate(user.getCreateTime()));
		}
		return userBean;
	}

}
