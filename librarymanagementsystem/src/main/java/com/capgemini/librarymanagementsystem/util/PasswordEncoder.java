package com.capgemini.librarymanagementsystem.util;

import java.util.Scanner;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordEncoder {

	public static String passwordEncoder(String plainPassword) {
		return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
		
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the password to be encoded: ");
		System.out.println(passwordEncoder(scanner.nextLine()));
		scanner.close();
	}
	
}
