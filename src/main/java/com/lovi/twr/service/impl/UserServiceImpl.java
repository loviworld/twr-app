package com.lovi.twr.service.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import com.lovi.puppyio.core.web.ApplicationContextData;
import com.lovi.twr.model.User;
import com.lovi.twr.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private final String CONTEXT_KEY = "users"; 
	@Override
	public void save(ApplicationContextData contextData, User user) {
		List<User> users = contextData.get(CONTEXT_KEY);
		if(users == null)
			users = new ArrayList<User>();
		users.add(user);
		contextData.put(CONTEXT_KEY, users);
	}

	@Override
	public List<User> findAll(ApplicationContextData contextData) {
		List<User> users = contextData.get(CONTEXT_KEY);
		if(users == null)
			users = new ArrayList<User>();
		return users;
	}

	@Override
	public User findById(ApplicationContextData contextData, int id) {
		List<User> users = contextData.get(CONTEXT_KEY);
		if(users == null)
			return null;
		else{
			for(User u : users){
				if(u.getId() == id)
					return u;
			}
			return null;
		}
			
				
	}

	@Override
	public User update(ApplicationContextData contextData, User user) {
		List<User> users = contextData.get(CONTEXT_KEY);
		if(users == null)
			return null;
		else{
			for(User u : users){
				if(u.equals(user))
					return u;
			}
			return null;
		}
	}

	@Override
	public void removeById(ApplicationContextData contextData, User user) {
		
	}
}
