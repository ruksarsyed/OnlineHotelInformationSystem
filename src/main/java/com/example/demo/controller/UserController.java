package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserModel;
import com.example.demo.repository.UserRepository;
import com.example.demo.serviceImpl.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserServiceImpl userObj;
	@Autowired
	private UserRepository u;

	@GetMapping("/user")
	public ResponseEntity<List<UserModel>> getAllUsers() {
		List<UserModel> list = userObj.getAllUsers();
		if (list.size() <= 0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@GetMapping("user/{id}")
	public ResponseEntity<UserModel> getSingleUser(@Valid @PathVariable int id) {
		Optional<UserModel> user = u.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/user")
	public ResponseEntity<UserModel> saveUser(@Valid @RequestBody UserModel user) {
		UserModel model = null;
		try {
			model = this.userObj.saveUser(user);
			System.out.println(user);
			return ResponseEntity.of(Optional.of(model));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).build();
		}
	}

	@DeleteMapping("/user/{id}")
	public ResponseEntity<Void> deleteUser(@Valid @PathVariable("id") int id) {
		try {
			this.userObj.deleteUser(id);
			return ResponseEntity.status(HttpStatus.IM_USED).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@PutMapping("/user/{id}")
	public ResponseEntity<UserModel> updateUser(@Valid @RequestBody UserModel user, @Valid @PathVariable("id") int id) {
//		userObj.updateUser(user, id);
//		return new ResponseEntity<>(userObj.getSingleUser(id),HttpStatus.OK);
		try {
			this.userObj.updateUser(user, id);
			user.setUserId(id);
			return ResponseEntity.ok().body(user);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.LENGTH_REQUIRED).build();
		}
	}
}