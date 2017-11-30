package com.anzy.bussiness.sysmng.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anzy.bussiness.sysmng.dao.UserDao;
import com.anzy.bussiness.sysmng.entity.User;
import com.anzy.bussiness.sysmng.service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public List<User> listUser() {
		// TODO Auto-generated method stub
		return userDao.listUser();
	}

}
