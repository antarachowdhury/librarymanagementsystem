package com.campegmini.librarymanagementsystem.service;

import java.util.List;

import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.User;

public interface AdminInterface {
	public User loginAdmin(String email, String password);
	public boolean updateUser(int id, User user);
	public boolean deleteUser(int id);
	public List<String> viewAllUsers(String type);
	public boolean add(User u);
    public List<String> viewAllBooks();
    public List<String> searchAllBooks(String bookname);
    public boolean addbook(BookInfoBean bookInfo);
    public boolean deleteBook(int id);
}
