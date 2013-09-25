package com.library.bookmanagement_library.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.library.bookmanagement_library.beans.Author;
import com.library.bookmanagement_library.beans.Book;
import com.library.bookmanagement_library.dao.BookRepository;
import com.library.bookmanagement_library.dto.AuthorDto;
import com.library.bookmanagement_library.dto.AuthorsDto;
import com.library.bookmanagement_library.dto.LinkDto;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

@Path(value = "/v1/books/{isbn}/authors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthorResource {
	
	/*To view a author associated with a book by author's unique id*/
	@GET
	@Path(value = "/{id}")
	public Response viewAuthorById(@PathParam("id") Long id,
			@PathParam("isbn") String isbn){
		Book book = BookRepository.getBookById(isbn);
		Author author=new Author();
		author=book.getBookHelper().getAuthorById(id);
		AuthorDto authorDtoResponse=new AuthorDto(author);
		authorDtoResponse.addLink(new LinkDto("view-author","/books/"+isbn+"/authors/"+id,"GET"));
		return Response.status(200).entity(authorDtoResponse).build();
	}
	
	/*To view all author associated with a book by passing it's ISBN*/
	@GET
	public Response viewAllAuthors(@PathParam("isbn") String isbn){
		Book book = BookRepository.getBookById(isbn);
		AuthorsDto authorsDtoResponse=new AuthorsDto(book.getAuthors());
		return Response.status(200).entity(authorsDtoResponse).build();
	}
		
}
