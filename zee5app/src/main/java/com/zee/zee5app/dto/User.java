package com.zee.zee5app.dto;

import java.time.LocalDate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
//@AllArgsConstructor
//@NoArgsConstructor

public class User {//implements Comparable<User> {
	static {
		System.out.println("static block");
	}
	{
		System.out.println("initialization block");
	}
	public User() {
		System.out.println("hello from EDC");
	}
	
	public User(String firstName, String lastName, String email) {
		//super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public User(String userId, String firstName, String lastName, String email, LocalDate doj, LocalDate dob,
			boolean active) {
		this(userId, firstName, lastName, email, doj, dob);
		this.active = active;
	}
	
	public User(String userId, String firstName, String lastName, String email, LocalDate doj, LocalDate dob) {
		this(firstName, lastName, email);
		this.userId = userId;
		
		this.doj = doj;
		this.dob = dob;
	}

	@Setter(value = AccessLevel.NONE)
	private String userId;

	private String firstName;
	private String lastName;
	private String email;
	private LocalDate doj;
	private LocalDate dob;
	private boolean active;
//	@Override
//	public int compareTo(User o) {
//		// TODO Auto-generated method stub
//		
//		return this.userId.compareTo(o.userId);
//	}
}
