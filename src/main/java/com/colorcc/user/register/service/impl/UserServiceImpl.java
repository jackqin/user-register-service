package com.colorcc.user.register.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.colorcc.common.utils.DateUtil;
import com.colorcc.user.register.bean.UserBean;
import com.colorcc.user.register.dto.BaseDto;
import com.colorcc.user.register.dto.UserToBeanDto;
import com.colorcc.user.register.mapper.UserMapper;
import com.colorcc.user.register.model.User;
import com.colorcc.user.register.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	UserMapper userMapper;
	
	BaseDto<User, UserBean> userToBeanDto = new UserToBeanDto();
	
	public UserBean getUser(Long id) {
		
		if (id == null) {
			if (logger.isDebugEnabled()) {
				logger.debug("No user id equals null");
			}
			return null;
		}

		User user = userMapper.selectOne(id);
		if (user == null) {
			return null;
		}
		UserBean userBean = userToBeanDto.transferTtoBean(user);
		userBean.setId(user.getId());
		userBean.setEmail(user.getEmail());
		userBean.setUsername("User : " + user.getEmail());
		userBean.setRegisterDate(DateUtil.getInstances().getDate(user.getCreateTime()));
		return userBean;
	}

	public List<UserBean> getUserList(Long startRow, int fetchRows) {
		if( startRow < 0) {
			return null;
		}
		
		List<User> userList = userMapper.getUsers(startRow, fetchRows);
		if (userList == null) {
			return null;
		}
		List<UserBean> userBeanList = new ArrayList<UserBean> ();
		for (User user : userList ) {
			userBeanList.add(userToBeanDto.transferTtoBean(user));
		}
		return userBeanList;
	}

}
