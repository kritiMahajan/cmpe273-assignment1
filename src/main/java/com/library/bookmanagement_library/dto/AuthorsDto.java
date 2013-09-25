package com.library.bookmanagement_library.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.library.bookmanagement_library.beans.Author;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@JsonPropertyOrder(alphabetic = true)
public class AuthorsDto extends LinksDto {
	 private Collection<Author> authors;
	
	
	public AuthorsDto(Collection<Author> authors) {
			super();
			this.authors = authors;
    }

	public Collection<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Collection<Author> authors) {
		this.authors = authors;
	}
	 
}