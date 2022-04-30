package com.example.demo;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class HotelInformation1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	UserServiceImpl impl;
	@Autowired
	UserRepository user;

	@Test
	@Order(1)
	public void saveUser() {
		UserModel u=new UserModel();
		u.setUserId(1);
		u.setName("Sai");
		u.setEmailId("dsai@gmail.com");
		u.setPhNo("9989283678");
		u.setAddress("kdr");
		//u.setDateOfReg(2017, 1, 13);
		u.setUserPass("ker123");
		user.save(u);
		assertNotNull(user.findById(1).get());
	}
	private void assertNotNull(UserModel userModel) {
		// TODO Auto-generated method stub
		
	}
	@Test
	@Order(2)
	public void getAllUsers() {
		List<UserModel>list=user.findAll();
		assertThat(list).size().isGreaterThan(0);
	}
	
	@Test
	@Order(3)
	public void getSingleUser() {
		UserModel u=user.findById(1).get();
	assertEquals("Sai",u.getName());	
	}
	
	@Test
	@Order(4)
	public void updateUser() {
		UserModel um=user.findById(1).get();
		um.setName("SaiKiran");
		user.save(um);
		assertNotEquals("Kiran",user.findById(1).get().getName());
	}
	@Test
	@Order(5)
	private void assertNotEquals(String string, String name) {
		// TODO Auto-generated method stub

		}
		@Test
		@Order(5)
	public void deleteUser() {
		user.deleteById(1);
		assertThat(user.existsById(1)).isFalse();
	}
	
	

}