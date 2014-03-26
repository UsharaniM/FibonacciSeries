/**
* This Fibonacci program calls a Restful webservice
* to calculate fibonacci series
* and returns the output in a JSON document.
*
* @author  Usha Rani
* @version 1.0
* @since   2014-03-25 
*/

package com.app.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.app.impl.SeriesImpl;

//@Path here defines class level path. Identifies the URI path that 
//a resource class will serve requests for.
@Path("series")

//@Produces here defines the media type(s).
//Here it produces a JSON document.
@Produces(MediaType.APPLICATION_JSON)
public class FibonacciResource {
	
	// @GET here defines, this method will method will process HTTP GET requests.
	@GET
    
   // @Path here defines method level path.
	@Path("/fibonacci/{end}")
	
	// @PathParam injects the value of URI parameter that defined in @Path
	// expression into the method.
	public String getFibonacci(@PathParam("end") int fibonacciElements) 
	{
		SeriesImpl sl = new SeriesImpl();
		String Fibseries = null;
		try
		{
		 Fibseries = sl.getFibonacci(fibonacciElements);   //calls the getFibonacci method in SeriesImpl.java
		}
		catch(IllegalArgumentException e)
		{
			Fibseries = e.getMessage();	
		}
		return Fibseries;
	}
		
		
	}
	

