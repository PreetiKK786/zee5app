package com.zee.zee5app.repo;

import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;

public interface UserRepo {
	public User insertUser(User user);
	public String updateUser(String UserId,User user) throws InvalidIdException;
	public String deleteUserById(String userId) throws NoDataFoundException;
	public Optional<User[]> getAllUsers();
	public Optional<User> getUserById (String UserId);
}
