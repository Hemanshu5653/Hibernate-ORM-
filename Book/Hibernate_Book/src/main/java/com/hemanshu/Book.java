package com.hemanshu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Books")
public class Book {
	@Id
	@Column(name = "Book_id")
	int bookId;
	@Column(name = "Book_name")
	String bookName;
	@Column(name = "Book_rating")
	int rating;
	
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(int bookId, String bookName, int rating) {
		
		this.bookId = bookId;
		this.bookName = bookName;
		this.rating = rating;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	

}
