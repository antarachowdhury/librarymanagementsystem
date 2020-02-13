package com.campegmini.librarymanagementsystem.dao;

import java.util.List;

import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.User;

public interface AdminDaoInterface {
	public User loginAdmin(String username, String password);



	public boolean updateUser(int id, User user);

	public boolean deleteUser(int id);
	public boolean deleteBook(int id);

	public boolean addbook(BookInfoBean book);

	public List<String> searchAllBooks(String bookname);

	public List<String> viewAllUsers(String type);

	public boolean add(User u);

}
