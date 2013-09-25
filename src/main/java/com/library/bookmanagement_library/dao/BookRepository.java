package com.library.bookmanagement_library.dao;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import com.library.bookmanagement_library.beans.Book;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

public class BookRepository {
	//book repository
	private static ConcurrentHashMap<String, Book> bookRepository = new ConcurrentHashMap<String, Book>();
	
	public static Book getBookById(String isbn) {
		return bookRepository.get(isbn);
	}
	
	//Adding new book to repository and returning it's unique generated ISBN
	public static String addBookToRepository(Book book){
		String isbn=generateISBN();
		book.setIsbn(isbn);
		bookRepository.put(isbn, book);
		return isbn;
	}
	
	//Deleting existing book from repository based on unique ISBN

	public static void deleteBookFromRepository(String isbn){	
		bookRepository.remove(isbn);
	}
	
	//Generating random ISBN
	private static String generateISBN() {
		return UUID.randomUUID().toString();
	}

}
