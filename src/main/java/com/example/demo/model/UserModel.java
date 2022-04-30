package com.example.demo.model;


import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class UserModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private int userId;
	@NotBlank(message = "Name is mandatory")
	@Column(name = "name")
	private String name;
	@NotBlank(message = "Email is mandatory")
	@Email
	@Column(name = "email_id")
	private String emailId;
	@Size(min = 10, max = 10, message = "Number should have 10 digits onlyy")
	@Pattern(regexp = "(^$|[0-9]{10})")
	@Column(name = "ph_no")
	private String phNo;
	@NotBlank(message = "Address is mandatory")
	@Column(name = "address")
	private String address;
	@Column(name = "date_of_reg")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "Please provide a date.")
	private LocalDate dateOfReg;
	@NotBlank(message = "userPass is mandatory")
	@Column(name = "user_pass")
	private String userPass;

}