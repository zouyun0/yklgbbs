package com.neusoft.service;

import com.neusoft.bean.Userinfo;

public interface IUserService {
	//ע���û�
	int addUser(Userinfo user);
	Userinfo findUser(String email,String password);
}
