package com.zee.zee5app;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.service.UserService;
import com.zee.zee5app.service.UserServiceImpl;

public class Main {

	public static void main(String[] args) {
		UserService userService = UserServiceImpl.getInstance();
		userService.insertuser(
				new User("b001","Rahul","kumar","rahu@gmail.com",LocalDate.now(),LocalDate.of(1999, 12, 29)));
		
		userService.insertuser(
				new User("a001","abhi","chivate","abhi@gmail.com",LocalDate.now(),LocalDate.of(1988, 12, 9)));
		userService.insertuser(
				new User("c001","kaka","kumar","kaka@gmail.com",LocalDate.now(),LocalDate.of(2008, 12, 29)));
		
		Optional<User> result = userService.getUserByUserId("b001");
		//System.out.println(result);
		if(!result.isPresent()) {
			System.out.println("No Record Found");
		}
		else {
			User user = result.get();
			System.out.println(user);
		}
		System.out.println("");
		Optional<User[]> result1 = userService.getAllUser();
		if(!result1.isPresent()) {
			System.out.println("No Record Found");
		}
		else {
			User[] users = result1.get();
			for(User user : users)System.out.println(user);
		}
		
		try {
		 String update = userService.updateUser("b001", new User("b001","R","kumar","rahu@gmail.com",LocalDate.now(),LocalDate.of(1999, 12, 29)));
		 System.out.println(update);
		} catch (InvalidIdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println( userService.getAllUser());
		
		
		try {
			userService.deleteUser("c001");
		} catch (NoDataFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("");
		
		Optional<User[]> result6 = userService.getAllUser();
		if(!result6.isPresent()) {
			System.out.println("No Record Found");
		}
		else {
			User[] users = result6.get();
			for(User user : users)System.out.println(user);
		}
	}
}
