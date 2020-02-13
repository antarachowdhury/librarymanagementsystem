package com.campegmini.librarymanagementsystem.exceptions;

public class InvalidUserException extends Exception{
	String msg= "Please enter valid  user";
	public String getMessage() {
		 
		 return this.msg;
		 }
}
