package com.campegmini.librarymanagementsystem.dao;

import java.util.List;

import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.StudentBean;
import com.campegmini.librarymanagementsystem.dto.User;

public interface StudentDao {
	public User loginStudent(String email, String password);
	public List<BookInfoBean> searchBook(String bookName);
	public List<BookInfoBean> allBooks();
	public boolean borrowBook(StudentBean bean);
	public boolean returnBook(int id, int bookid);
	public String getBook(int id);
	
}
