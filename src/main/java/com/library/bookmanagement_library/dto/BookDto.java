package com.library.bookmanagement_library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.library.bookmanagement_library.beans.Book;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@JsonPropertyOrder(alphabetic = true)
public class BookDto extends LinksDto {
    private Book book;

    /**
     * @param book
     */
    public BookDto(Book book) {
	super();
	this.book = book;
    }

    /**
     * @return the book
     */
    public Book getBook() {
	return book;
    }

    /**
     * @param book
     *            the book to set
     */
    public void setBook(Book book) {
	this.book = book;
    }
}
