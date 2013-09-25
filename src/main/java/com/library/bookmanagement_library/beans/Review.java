package com.library.bookmanagement_library.beans;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

public class Review {
	@NotEmpty
	String rating,comment;
	
	Long reviewId;

	
	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
