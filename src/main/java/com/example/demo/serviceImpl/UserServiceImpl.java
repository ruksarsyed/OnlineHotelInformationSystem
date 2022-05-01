package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepository user;

	@Override
	public List<UserModel> getAllUsers()  {
		return user.findAll();
	}

	@Override
	public UserModel getSingleUser(int id) {
		return user.findById(id).get();
	}

	@Override
	public UserModel saveUser(UserModel obj) {
		return user.save(obj);
	}

	@Override
	public UserModel updateUser(UserModel obj, int id) {
		return user.save(obj);
	}

	@Override
	public void deleteUser(int id) {
		user.deleteById(id);

	}

}