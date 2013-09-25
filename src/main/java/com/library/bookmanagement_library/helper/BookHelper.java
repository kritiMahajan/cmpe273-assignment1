package com.library.bookmanagement_library.helper;

import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

import com.library.bookmanagement_library.beans.Author;
import com.library.bookmanagement_library.beans.Review;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

public class BookHelper {
	
	private ConcurrentHashMap<Long, Author> authors;
	private ConcurrentHashMap<Long, Review> reviews;
	Random r;
	
	public BookHelper(){
		authors=new ConcurrentHashMap<Long, Author>();
		reviews=new ConcurrentHashMap<Long, Review>();
		r = new Random(100000000);
	}

	public long addReview(Review review) {
		long reviewId = r.nextLong();
		review.setReviewId(reviewId);
		reviews.put(reviewId, review);
		return reviewId;
	}
	
	public Review getReviewById(long reviewId){
		return reviews.get(reviewId);
	}
	
	public Collection<Review> getAllReviews(){
		return reviews.values();
	}
	
	public long addAuthor(Author author) {
		long authorId = r.nextLong();
		author.setId(authorId);
		authors.put(author.getId(), author);
		return authorId;
	}
	
	public Author getAuthorById(long id){
		return authors.get(id);
	}
}