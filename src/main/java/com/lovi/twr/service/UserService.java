package com.lovi.twr.service;

import java.util.List;
import com.lovi.puppyio.core.web.ApplicationContextData;
import com.lovi.twr.model.User;

public interface UserService {

	public void save(ApplicationContextData contextData, User user);
	public List<User> findAll(ApplicationContextData contextData);
	public User findById(ApplicationContextData contextData, int user);
	public User update(ApplicationContextData contextData, User user);
	public void removeById(ApplicationContextData contextData, User user);
}
