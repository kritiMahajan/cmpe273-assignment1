package com.library.bookmanagement_library.resource;

import java.util.ArrayList;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.bookmanagement_library.beans.Author;
import com.library.bookmanagement_library.beans.Book;
import com.library.bookmanagement_library.dao.BookRepository;
import com.library.bookmanagement_library.dto.BookDto;
import com.library.bookmanagement_library.dto.LinkDto;
import com.library.bookmanagement_library.dto.LinksDto;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@Path(value = "/v1/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookResource {
	
	/*To add a new book to our book repository*/
	@POST	
	public Response createBook(@Valid Book book)
	{
			//"Author Name Cannot Be NULL/BLANK";
		for(Author author:book.getAuthors()){				
			if(author.getName().equals(null) || author.getName().isEmpty()){
				return Response.status(422).build();
						
			}
		}		
		
		String isbn=BookRepository.addBookToRepository(book);
		
		// For book related links
		LinksDto bookResponse = new LinksDto();	    
		bookResponse.addLink(new LinkDto("view-book","/books/" + isbn,"GET"));
		bookResponse.addLink(new LinkDto("update-book",	"/books/" + isbn, "PUT"));
		bookResponse.addLink(new LinkDto("delete-book",	"/books/" + isbn, "DELETE"));
		bookResponse.addLink(new LinkDto("create-review","/books/" + isbn+ "/reviews", "POST"));		
		
		return Response.status(201).entity(bookResponse).build(); 
	}
	
	/*To get a existing book using it's unique ISBN*/
	@GET
	@Path(value = "/{isbn}")
	public Response viewBook(@PathParam("isbn") String isbn){
		
		Book book = BookRepository.getBookById(isbn);				
		BookDto bookResponse = new BookDto(book);
	    
	    // For book related links		
		bookResponse.addLink(new LinkDto("view-book","/books/" + isbn,"GET"));
		bookResponse.addLink(new LinkDto("update-book",	"/books/" + isbn, "PUT"));
		bookResponse.addLink(new LinkDto("delete-book",	"/books/" + isbn, "DELETE"));
		
		// For review related links
		bookResponse.addLink(new LinkDto("create-review","/books/"+ isbn+"/reviews", "POST"));
		if(book.getBookHelper().getAllReviews().size() > 0){
			bookResponse.addLink(new LinkDto("view-all-reviews","/books/"+isbn+"/reviews", "GET"));
		}
		
		// For author related links		
		for(Author author : book.getAuthors()){
			bookResponse.addLink(new LinkDto("view-author","/books/"+isbn+"/authors/"+author.getId(),"GET"));			
			
		}
		
		return Response.status(200).entity(bookResponse).build();
	}
	
	/*To delete a existing book using it's unique ISBN*/
	@DELETE	
	@Path(value = "/{isbn}")
	public Response deleteBook(@PathParam("isbn") String isbn){
		
		Book bookToBeDeleted=BookRepository.getBookById(isbn);
		
		// For  Post book link
		LinksDto links = new LinksDto();
		links.addLink(new LinkDto("create-book", "/books","POST"));
		
		if(bookToBeDeleted != null){
			BookRepository.deleteBookFromRepository(isbn);
		}else{
			//Book do not exist
			return Response.status(404).build();
			
		}
		
		return Response.status(200).entity(links).build(); 
	
	}
	
	/*To update the status of a existing book's using it's unique ISBN*/
	@PUT
	@Path(value = "/{isbn}")
	public Response updateBook(@PathParam("isbn") String isbn,
							   @QueryParam("status") String status){
		
		//Status is different from predefined status's
		final ArrayList<String> statusList=new ArrayList<String>();
		statusList.add("available");
		statusList.add("checked-out");
		statusList.add("in-queue");
		statusList.add("lost");
		if(!statusList.contains(status)){		
			return Response.status(404).build();			
		}
	
		Book bookToBeUpdated=BookRepository.getBookById(isbn);		
		bookToBeUpdated.setStatus(status);		
		
		// For book related links
		LinksDto bookResponse = new LinksDto();
		bookResponse.addLink(new LinkDto("view-book","/books/" + isbn,"GET"));
		bookResponse.addLink(new LinkDto("update-book",	"/books/" + isbn, "PUT"));
		bookResponse.addLink(new LinkDto("delete-book",	"/books/" + isbn, "DELETE"));
		
		// For review related links
		bookResponse.addLink(new LinkDto("create-review","/books/"+ isbn+"/reviews", "POST"));
		if(bookToBeUpdated.getBookHelper().getAllReviews().size() > 0){
			bookResponse.addLink(new LinkDto("view-all-reviews","/books/"+isbn+"/reviews", "GET"));
		}
		return Response.status(200).entity(bookResponse).build();
	}
	
}