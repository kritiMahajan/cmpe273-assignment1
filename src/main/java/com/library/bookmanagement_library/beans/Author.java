package com.library.bookmanagement_library.beans;

import javax.validation.Valid;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

public class Author {
	@NotEmpty
	String  name;
	long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
