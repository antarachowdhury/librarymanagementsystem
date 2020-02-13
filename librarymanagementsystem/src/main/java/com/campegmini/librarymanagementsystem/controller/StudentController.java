package com.campegmini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.campegmini.librarymanagementsystem.daoimpl.StudentImpl;
import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.User;
import com.campegmini.librarymanagementsystem.exceptions.BookNotFoundException;
import com.campegmini.librarymanagementsystem.exceptions.InvalidOptionException;
import com.campegmini.librarymanagementsystem.service.StudentService;
import com.campegmini.librarymanagementsystem.serviceimpl.StudentServiceImpl;

public class StudentController {

	static Logger log = LogManager.getLogger("student");

	StudentService service=new StudentServiceImpl();

	void details() {
		log.info("Student Selected");
		log.info("Please Login");
		Scanner scanner = new Scanner(System.in);
		log.info("Enter student email");
		String email = scanner.nextLine();
		log.info("Enter password");
		String password = scanner.next();
		User bean= service.loginStudent(email, password);
		if(bean!=null) {	
			log.info("Student logged in successfully");

			log.info(" Choose student operations: ");
			log.info("1.Search book");
			log.info("2.Borrow book");
			log.info("3.Return book");
			log.info("4.Show all books");


			int i = scanner.nextInt();
			switch (i) {
			case 1: {
				StudentImpl s1 = new StudentImpl();
				System.out.println("Enter the book name");
				scanner.nextLine();
				String search=scanner.nextLine();
				List<BookInfoBean> books = s1.searchBook(search);

				if(!books.isEmpty()) {
					for (BookInfoBean bookInfo : books) {
						log.info("Book Name    :"+bookInfo.getBookname());
						log.info("Author name  :"+bookInfo.getAuthorname());
						log.info("Price        :"+bookInfo.getPrice());
					}
				}else {
					try {
						throw new BookNotFoundException();
					}catch(Exception e) {
						log.info(e.getMessage());
					}
				}

			}
			break;
			case 2: 
				int studentId=bean.getId();
				service.borrowBook(studentId);
				break;


			case 3: 

				int Id=bean.getId();
				service.returnBook(Id);

				break;
			case 4:
				log.info("------All Books---------");
				List<BookInfoBean> beans=service.allBooks();
				if(!beans.isEmpty()) {

					for (BookInfoBean bookInfoBean : beans) {

						log.info(bookInfoBean.getBookid()+")"+bookInfoBean.getBookname());

					}
				}
				break;
			default :
				log.info("Invalid");

			}
		}else {
			try {
				throw new InvalidOptionException();
			}catch(Exception e) {
				log.info(e.getMessage());
			}
		}
	}
}
