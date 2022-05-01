package com.example.demo.serviceImpl;

import java.util.List;

import com.example.demo.model.UserModel;

public interface UserService {

	List<UserModel> getAllUsers() ;

	UserModel getSingleUser(int id);

	UserModel saveUser(UserModel obj);

	UserModel updateUser(UserModel obj,int id);

	void deleteUser(int id);



}