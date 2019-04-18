package com.example.scheduledtest.service.Impl;


import com.example.scheduledtest.dao.UserMapper;
import com.example.scheduledtest.pojo.User;
import com.example.scheduledtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void insertUser(User user) {
		userMapper.insert(user);
		
	}

}
