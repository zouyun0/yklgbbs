package com.neusoft.service;

import com.neusoft.bean.Userinfo;
import com.neusoft.dao.IUserDao;
import com.neusoft.dao.UserDaoImp;
import com.neusoft.utils.Md5Utils;

public class UserServiceImp implements IUserService{

	@Override
	public int addUser(Userinfo user) {
		// 调用dao层完成注册
		IUserDao iud=new UserDaoImp();
		int rel=iud.addUser(user);
		return rel;
	}

	@Override
	public Userinfo findUser(String email, String password) {
		IUserDao iud=new UserDaoImp();
		Userinfo user=iud.findUser(email, Md5Utils.md5(password));
		return user;
	}

}
