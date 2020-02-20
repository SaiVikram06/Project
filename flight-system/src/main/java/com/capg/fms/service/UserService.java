package com.capg.fms.service;

import java.util.List;
import java.util.Map;

import com.capg.fms.model.User;

public interface UserService {
	
	public void initialAdminList();
	public void initialCustomerList();
	public boolean addUser(User user);
	public List<User> viewUser();
	public Map<Long,User> getUser();
	public User viewUser(long userId);
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException;
	public boolean validateEmail(String mail) throws InvalidDetailsException;
	public boolean validateCustomerId(long id) throws InvalidDetailsException;
	public boolean validatePassword(String pw) throws InvalidDetailsException;
}
