package com.zee.zee5app.service;

import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;

public interface UserService {

	public User insertuser(User user);
	public String updateUser(String UserId,User user) throws InvalidIdException;
	public String deleteUser(String userId) throws NoDataFoundException;
	public Optional<User[]> getAllUser();
	public Optional<User> getUserByUserId (String UserId);
}
