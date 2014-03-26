/**
* This Application class holds all resource classes.
*
* @author  Usha Rani
* @version 1.0
* @since   2014-03-25 
*/
package com.app.application;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.app.resource.FibonacciResource;

public class FibonacciApplication extends Application{
	
	/*
	 * Overriding to add resource classes	 
	 * @see javax.ws.rs.core.Application#getClasses()
	 */
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<Class<?>>();
		classes.add(FibonacciResource.class);
		return classes;
	}

}
