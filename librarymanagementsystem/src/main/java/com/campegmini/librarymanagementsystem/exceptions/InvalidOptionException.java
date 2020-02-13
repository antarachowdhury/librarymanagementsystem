package com.campegmini.librarymanagementsystem.exceptions;

public class InvalidOptionException extends Exception {
	String msg= "Invalid option";
	public String getMessage() {
		 
		 return this.msg;
		 }
}
