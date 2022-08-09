package com.zee.zee5app.repo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.InvalidIdException;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.utils.IdComparator;

public class UserRepoImpl implements UserRepo {
	
	private List<User> users = new ArrayList<>();
	private UserRepoImpl() {
        // TODO Auto-generated constructor stub
    }
    
    private static UserRepo userRepo;
    
    public static UserRepo getInstance() {
        // userRepo object
        
        if(userRepo == null) {
            userRepo = new UserRepoImpl();
            
        }
        
        return userRepo;
    }
    Comparator<User> comparator = (e1,e2)->e1.getUserId().compareTo(e2.getUserId());
	@Override
	public User insertUser(User user) {
		// TODO Auto-generated method stub
		boolean result =  users.add(user);
		Collections.sort(users,comparator);
		if(result) {
			System.out.println("done");
			return user;
		}
		else return null;
	}

	@Override
	public String updateUser(String userId, User user) throws InvalidIdException {
		// TODO Auto-generated method stub
		Optional<User> optional = this.getUserById(userId);
		//int d = users.indexOf(optional);
		if(optional.isPresent()) {
			users.set(users.indexOf(optional.get()), user);
			return "Success";
		}else {
			throw new InvalidIdException("Id Not FOund");
		}
		
		
	}

	@Override
	public String deleteUserById(String userId) throws NoDataFoundException {
		// TODO Auto-generated method stub
		Optional<User> optional = this.getUserById(userId);
		
		if(optional.isPresent()) {
			users.remove(optional.get());
			return "success";
		}
		else {
			throw new NoDataFoundException(userId+  " Data Not Found");
		}
		
	}

	@Override
	public Optional<User[]> getAllUsers() {
		// TODO Auto-generated method stub
		if(this.users.isEmpty()) {
			return Optional.empty();
		}
		User[] users  = new User[this.users.size()];
		this.users.toArray(users);
		return Optional.of(users);
	}

	@Override
	public Optional<User> getUserById(String UserId) {
		// TODO Auto-generated method stub
		for(User user : users) {
			if(user!=null && UserId.equals(user.getUserId())) {
				return Optional.of(user);
			}
		}
		return Optional.empty();
	}

}
