package com.campegmini.librarymanagementsystem.dto;

public class StudentBean {
	private int Id;
	private int Bookid;
	private String Bookname;
//	private int student_id;
	private String Borrowdate;
	private String Returndate;
	




//	public int getStudent_id() {
//		return student_id;
//	}
//	public void setStudent_id(int student_id) {
//		this.student_id = student_id;
//	}



	
	
	public int getId() {
		return Id;
	}
	
	public void setId(int id) {
		Id = id;
	}
	public int getBook_id() {
		return Bookid;
	}
	public void setBook_id(int book_id) {
		Bookid = book_id;
	}
	public String getBookname() {
		return Bookname;
	}
	public void setBookname(String bookname) {
		Bookname = bookname;
	}
	
	public String getBorrow_date() {
		return Borrowdate;
	}
	public void setBorrow_date(String borrow_date) {
		Borrowdate = borrow_date;
	}
	public String getReturn_date() {
		return Returndate;
	}
	public void setReturn_date(String return_date) {
		Returndate = return_date;
	}

	
	public StudentBean(int id, int bookid, String bookname, String borrowdate, String returndate) {
		super();
		Id = id;
		Bookid = bookid;
		Bookname = bookname;
		Borrowdate = borrowdate;
		Returndate = returndate;
	
	}

	public StudentBean() {
		
	}
	
	
}
