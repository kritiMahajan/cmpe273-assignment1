package com.library.bookmanagement_library.dto;

import java.util.Collection;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.library.bookmanagement_library.beans.Review;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@JsonPropertyOrder(alphabetic = true)
public class ReviewsDto extends LinksDto {
    private Collection<Review> reviews;
    
    public ReviewsDto(Collection<Review> reviews){
    	this.reviews = reviews;
    }

	public Collection<Review> getReviews() {
		return reviews;
	}

	public void setReviews(Collection<Review> reviews) {
		this.reviews = reviews;
	}

}
