package com.library.bookmanagement_library.beans;

import java.util.ArrayList;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.bookmanagement_library.helper.BookHelper;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */
public class Book {
	private String isbn;
	@NotEmpty
	private String title;
	private String language;
	
	@NotEmpty
	@JsonProperty("publication-date")
	private String publicationDate;
	
	private String status = "available";
	
	@JsonProperty("num-pages")
	private int numberOfPages;
	//Author Repository
	
	private ArrayList<Author> authors;
	
	@JsonIgnore
	private BookHelper bookHelper;
	
	public Book(){
		bookHelper = new BookHelper();
	}
	
	public BookHelper getBookHelper() {
		return bookHelper;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}
	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}
	
	public ArrayList<Author> getAuthors() {
		return authors;
	}
	@Valid
	public void setAuthors(ArrayList<Author> authors) {
		for(Author author:authors){
			long authorId = bookHelper.addAuthor(author);
			author.setId(authorId);
		}
		this.authors = authors;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}