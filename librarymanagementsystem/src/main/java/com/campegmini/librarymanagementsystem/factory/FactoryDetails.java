package com.campegmini.librarymanagementsystem.factory;

import com.campegmini.librarymanagementsystem.dao.AdminDaoInterface;
import com.campegmini.librarymanagementsystem.dao.StudentDao;
import com.campegmini.librarymanagementsystem.daoimpl.AdminDao;
import com.campegmini.librarymanagementsystem.daoimpl.StudentImpl;

public class FactoryDetails {
	private FactoryDetails() {
		
	}
public static AdminDaoInterface adminDao() {
	AdminDaoInterface admin = new AdminDao();
	return admin;
}
public static StudentDao studentDao() {
	StudentDao student = new StudentImpl();
	return student;
}
}
