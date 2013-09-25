package com.library.bookmanagement_library.resource;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.bookmanagement_library.beans.Book;
import com.library.bookmanagement_library.beans.Review;
import com.library.bookmanagement_library.dao.BookRepository;
import com.library.bookmanagement_library.dto.LinkDto;
import com.library.bookmanagement_library.dto.LinksDto;
import com.library.bookmanagement_library.dto.ReviewDto;
import com.library.bookmanagement_library.dto.ReviewsDto;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@Path(value = "/v1/books/{isbn}/reviews")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ReviewResource {
	
		/*To create reviews for a particular book*/

		@POST		
		public Response createReview(@PathParam("isbn") String isbn, @Valid Review review){
			Book book=BookRepository.getBookById(isbn);
			long reviewId = book.getBookHelper().addReview(review);
			LinksDto reviewResponse = new LinksDto();
			reviewResponse.addLink(new LinkDto("view-review","/books/"+isbn+"/reviews/"+reviewId,"GET"));
			return Response.status(201).entity(reviewResponse).build();
		}
		
		/*To view  reviews identified by its unique review id  for a particular book*/
		@GET
		@Path(value ="/{id}")
		public Response viewReviewById(@PathParam("id") Long id, @PathParam("isbn") String isbn){
			Book book = BookRepository.getBookById(isbn);
			Review review = book.getBookHelper().getReviewById(id);
			ReviewDto reviewDtoResponse=new ReviewDto(review);
			reviewDtoResponse.addLink(new LinkDto("view-review","/books/"+isbn+"/reviews/"+id,"GET"));
			return Response.status(200).entity(reviewDtoResponse).build();
		}
		
		/*To view all reviews for a particular book*/
		@GET		
		public Response viewAllReviews(@PathParam("isbn") String isbn){
			Book book=BookRepository.getBookById(isbn);
			ReviewsDto reviewsResponse = new ReviewsDto(book.getBookHelper().getAllReviews());
			return Response.status(200).entity(reviewsResponse).build();
		}
}
