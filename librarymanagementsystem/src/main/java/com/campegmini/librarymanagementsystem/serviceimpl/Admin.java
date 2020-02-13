package com.campegmini.librarymanagementsystem.serviceimpl;

import java.util.List;

import com.campegmini.librarymanagementsystem.daoimpl.AdminDao;
import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.User;
import com.campegmini.librarymanagementsystem.service.AdminInterface;

public class Admin implements AdminInterface  {
	private AdminDao dao = new AdminDao();




	public User loginAdmin(String email, String password) {
		return dao.loginAdmin(email, password);
	}



	public boolean deleteUser(int id) {
		
			return dao.deleteUser(id);
		
	}
	public List<String> viewAllUsers(String type) {
		List<String> res = dao.viewAllUsers(type);
		return res;
	}

	public boolean add(User u) {
	//	if(ValidateEmail.isValid(u.getEmail())&&ValidatePassword.validate(u.getPassword()))
		{
			return dao.add(u);

		} 
	//	return false;
	
	}
	


	public List<String> searchAllBooks(String bookname) {

		List<String> res1 = dao.searchAllBooks(bookname);
		return res1;
	}

	public boolean updateUser(int id, User user) {

		return dao.updateUser(id, user);
	}



	public List<String> viewAllBooks() {

		return null;
	}



	public boolean deleteBook(int id) {
 
			return dao.deleteBook(id);
			
		
	}



	@Override
	public boolean addbook(BookInfoBean bookInfo) {
		return dao.addbook(bookInfo);
	}
}
