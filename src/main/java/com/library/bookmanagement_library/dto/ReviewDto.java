package com.library.bookmanagement_library.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.library.bookmanagement_library.beans.Review;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@JsonPropertyOrder(alphabetic = true)
public class ReviewDto extends LinksDto {
    private Review review;
    
    public ReviewDto(Review review){
    	this.review = review;
    }
    
	public Review getReview() {
		return review;
	}

	public void setReview(Review review) {
		this.review = review;
	}

}
