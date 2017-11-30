package com.anzy.bussiness.sysmng.service.impl;

import org.springframework.stereotype.Service;

import com.anzy.bussiness.sysmng.dao.UserDao;
import com.anzy.bussiness.sysmng.entity.User;
import com.anzy.bussiness.sysmng.service.UserService;
import com.anzy.freemarker.base.service.impl.BaseServiceImpl;
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService{

}
