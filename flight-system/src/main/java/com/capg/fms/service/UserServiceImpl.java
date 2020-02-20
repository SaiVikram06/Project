package com.capg.fms.service;

import java.util.List;
import java.util.Map;

import com.capg.fms.dao.UserDao;
import com.capg.fms.dao.UserDaoImpl;
import com.capg.fms.model.User;

public class UserServiceImpl implements UserService {
	
	static UserDao d=new UserDaoImpl();
	
	public boolean addUser(User user) {
		return d.addUser(user); 
	}

	public List<User> viewUser() {
		return d.viewUser();	
	}

	public Map<Long, User> getUser() {
		return d.getUser();	
	}

	public User viewUser(long userId) {
		return d.viewUser(userId);	
	}

	public void initialAdminList() {
		d.addSomeAdmins();
	}
	
	public void initialCustomerList() {
		d.addSomeCustomers();
	}
	
	public boolean validatePhoneNo(long phoneNo) throws InvalidDetailsException {
		String s=Long.toString(phoneNo);
		if(s.length()==10 && s.charAt(0)!=0)
			return true;
		else
			throw new InvalidDetailsException("Invalid Phone Number");	
	}

	public boolean validateEmail(String email) throws InvalidDetailsException {
		
	      String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      if(email.matches(regex))
	    	  return true;
	      else
	    	  throw new InvalidDetailsException("Invalid email Id");
	   }
	
	public boolean validateCustomerId(long id) throws InvalidDetailsException {
		int count=0;
		while(id>0) {
			long d=id % 10;
			count++;
			id=id/10;
		}
		if(count>=6)
			return true;
		else
			throw new InvalidDetailsException("Invalid ID");	
	}

	public boolean validatePassword(String pw) throws InvalidDetailsException {
		if(pw.length()>=8) {
			return true;
		}
		else {
			throw new InvalidDetailsException("Password should be of minimun 8 characters");
		}
	}


}
