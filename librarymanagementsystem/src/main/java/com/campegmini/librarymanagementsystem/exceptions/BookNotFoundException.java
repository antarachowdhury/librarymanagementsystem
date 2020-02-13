package com.campegmini.librarymanagementsystem.exceptions;

public class BookNotFoundException extends Exception {
	String msg= "Please enter valid book name";
	public String getMessage() {

		return this.msg;
	}
}
