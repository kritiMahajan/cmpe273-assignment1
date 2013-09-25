package com.library.bookmanagement_library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.library.bookmanagement_library.beans.Author;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@JsonPropertyOrder(alphabetic = true)
public class AuthorDto extends LinksDto {
	 private Author author;
	
	
	public AuthorDto(Author author) {
			super();
			this.author = author;
    }
	 
	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

}