package com.campegmini.librarymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.campegmini.librarymanagementsystem.dto.BookInfoBean;
import com.campegmini.librarymanagementsystem.dto.User;
import com.campegmini.librarymanagementsystem.service.AdminInterface;
import com.campegmini.librarymanagementsystem.serviceimpl.Admin;
import com.capgemini.librarymanagementsystem.util.PasswordEncoder;

public class AdminController {
	static Logger log = LogManager.getLogger("admin");
	AdminInterface service = new Admin();
	Scanner scan = new Scanner(System.in); 
	void  details(){
		log.info("Admin Selected");
		log.info("Please Login");
		log.info("Enter admin email");
		String email = scan.nextLine();
		log.info("Enter password");
		String password = scan.next();
		User bean = service.loginAdmin(email, password);
		if(bean!=null) {
			if(bean.getUsertype().equals("admin")) {
				log.info("Admin Login successfull");
				log.info(" Choose Admin operations are:");
				log.info("1.View Users");
				log.info("2.Add User");
				log.info("3.Delete User");
				log.info("4.Update User");
				log.info("5.Search Book");
				log.info("6.Add Book");
				log.info("7.delete Book");

				int i = scan.nextInt();
				switch (i) {
				case 1: {

					List<String> result = service.viewAllUsers("Student");
					for (String str : result) {
						log.info(str);
					}
					break;
				}
				case 2: 
				{
					User user = new User();

					log.info("Enter User details: ");
					log.info("Enter Usertype: ");
					String usertype = scan.next();
					user.setUsertype(usertype);
					log.info("Enter Username: ");
					String username = scan.next();
					user.setUsername(username);
					log.info("Enter Id: ");
					int id = scan.nextInt();
					user.setId(id);
					log.info("Enter Password: ");
					String password1 = scan.next();
					String passencoder= PasswordEncoder.passwordEncoder(password1);
					user.setPassword(passencoder);
					log.info("Enter Email: ");
					String email1 = scan.next();
					user.setEmail(email1);
					log.info("Enter Contact no: ");
					long contact = scan.nextLong();
					user.setContact(contact);
					if(service.add(user)) {
						log.info("Successfully Added");
					} else {
						log.info("Not Added");
					}

					break;


				}
				case 3: {
					Admin a3 = new Admin();
					log.info("Enter the id of user you want to delete: ");
					int id = scan.nextInt();
					boolean delete = a3.deleteUser(id);
					log.info("Record deleted: " + delete);

					break;
				}
				case 4: {
					User user = new User();
					log.info("Enter the id of user you want to update: ");
					int id = scan.nextInt();
					log.info("Enter username");
					String username=scan.next();
					user.setUsername(username);
					log.info("Enter password: ");
					String password1=scan.next();
					user.setPassword(password1);
					log.info("Enter email id: ");
					String email1=scan.next();
					user.setEmail(email1);
					log.info("Enter contact no: ");
					long contact=scan.nextLong();
					user.setContact(contact);
					boolean res=service.updateUser(id,user);
					if(res)
						log.info("Updation successfull");
					else
						log.info("Updation failed");
					break;
				}

				case 5: {
					log.info("Search book name");
					String name=scan.next();
					List<String> search = service.searchAllBooks(name);
					log.info("Searched book is:");
					for (String string : search) {
						log.info( string);
						log.info( "-----------------------");
					}
					break;
				}

				case 6: {
					BookInfoBean book=new BookInfoBean(); 

					log.info("Enter the book details: ");


					log.info("Enter bookId: ");
					int bookId=scan.nextInt();
					book.setBookid(bookId);
					log.info("Enter bookname: ");
					String bookname=scan.next();
					book.setBookname(bookname);

					log.info("Enter author name: ");
					String authorname=scan.next();
					book.setAuthorname(authorname);
					log.info("Enter book price: ");
					int  price=scan.nextInt();
					book.setPrice(price);

					log.info("Enter book quantity: ");
					int quantity=scan.nextInt();
					book.setQuantity(quantity);
					if(service.addbook(book)) {
						log.info("Book added successfully");
					}

				}
				break;
				case 7:
					log.info("Enter the id of book you want to delete: ");
					int id = scan.nextInt();

					boolean delete = service.deleteBook(id);
					if(delete) {
						log.info("Deleted");
					}

					break;
				default: {
					log.info("Invalid Choice!!");
				}

				}
			} else {
				log.info("You aren't admin");
			}

		} else {
			log.info(" Login failed");
		}
	}
}
