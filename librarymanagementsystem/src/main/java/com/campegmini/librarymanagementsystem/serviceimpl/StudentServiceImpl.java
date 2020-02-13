package com.campegmini.librarymanagementsystem.serviceimpl;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.campegmini.librarymanagementsystem.daoimpl.StudentImpl;
import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.StudentBean;
import com.campegmini.librarymanagementsystem.dto.User;
import com.campegmini.librarymanagementsystem.service.StudentService;

public class StudentServiceImpl implements StudentService {
	Scanner sc= new Scanner(System.in); 

	static Logger log = LogManager.getLogger("student");
	private StudentImpl impl = new StudentImpl();






	public User loginStudent(String email, String password) {


		
			return  impl.loginStudent( email,  password);
	
	



	} 



	public List<BookInfoBean> searchBook(String bookName) {
		List<BookInfoBean> res1=impl.searchBook(bookName);
		return res1;
	}


	public void borrowBook(int studentId) {
		log.info("------All Books---------");
		List<BookInfoBean> beans=impl.allBooks();
		if(!beans.isEmpty()) {
			log.info("------Select Book---------");

			for (BookInfoBean bookInfoBean : beans) {

				log.info(bookInfoBean.getBookid()+")"+bookInfoBean.getBookname());

			}
			StudentBean bean=new StudentBean();
			int bookId= sc.nextInt();//scanner class
			bean.setId(studentId);
			bean.setBook_id(bookId);
			bean.setBookname(impl.getBook(bookId));
			Date date=new Date(bookId);
			
			int month=date.getMonth()+1;
			int reData=month+1;
			bean.setBorrow_date((2020+"/"+month+"/"+date.getDate()));
			bean.setReturn_date(2020+"/"+reData+"/"+date.getDate());
			if(	impl.borrowBook(bean)) {
				log.info("Book is borrowed");
			} else {
				log.info("Not borrowed");
			}

		}else {
			log.info("------No book found---------");
		}

	}


	public void returnBook(int id) {
		log.info("Please enter the id of the book to be returned: ");
		int bookid=sc.nextInt(); 
		if(impl.returnBook(id, bookid)) {
			log.info("Book returned");
		} else {
			log.info("Not returned");
		}
	}



	@Override
	public List<BookInfoBean> allBooks() {
		
		return impl.allBooks();
	}
}
