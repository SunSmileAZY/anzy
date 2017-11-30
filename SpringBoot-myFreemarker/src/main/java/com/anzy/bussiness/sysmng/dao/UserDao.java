package com.anzy.bussiness.sysmng.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.anzy.bussiness.sysmng.entity.User;


public interface UserDao{
	@Select("select * from au_t_user")
	List<User> listUser();

	
}
