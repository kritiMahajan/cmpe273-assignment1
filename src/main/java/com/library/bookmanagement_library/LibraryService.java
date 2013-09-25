package com.library.bookmanagement_library;

import com.library.bookmanagement_library.config.LibraryServiceConfiguration;
import com.library.bookmanagement_library.resource.AuthorResource;
import com.library.bookmanagement_library.resource.BookResource;
import com.library.bookmanagement_library.resource.ReviewResource;
import com.library.bookmanagement_library.resource.RootResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;

/**
 * @author Kriti Mahajan
 * Assignment1-273
 *
 */

public class LibraryService extends Service<LibraryServiceConfiguration> {

    public static void main(String[] args) throws Exception {
	new LibraryService().run(args);
    }

    @Override
    public void initialize(Bootstrap<LibraryServiceConfiguration> bootstrap) {
    	bootstrap.setName("library-service");
    }

    @Override
    public void run(LibraryServiceConfiguration configuration,
	    Environment environment) throws Exception {
	/** Root API */
	environment.addResource(RootResource.class);
	/** Books APIs */
	environment.addResource(BookResource.class);
    
    /** Author APIs */
	environment.addResource(AuthorResource.class);
	/** Review APIs */
	environment.addResource(ReviewResource.class);
	
	
    	
    }
}