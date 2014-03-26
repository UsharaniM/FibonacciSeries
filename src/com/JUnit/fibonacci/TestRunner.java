/**
* This class is test runner which will run JUNIT test cases. and provides the result* 
*
* @author  Usha Rani
* @version 1.0
* @since   2014-03-25 
*/
package com.JUnit.fibonacci;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner 
{

	public static void main(String[] args) 
	{
		//Using Junit core to run test cases
		 Result result = JUnitCore.runClasses(TestFibonacciSeries.class);
		 // checking the any test cases failures
	      for (Failure failure : result.getFailures()) 
	      {
	         System.out.println("Testcase is failed due to the reason" + failure.toString());
	      }
	      // checking whether all test cases are successful
	      if(result.wasSuccessful())
	      {
	    	  System.out.println("All test cases are succesfully executed");
	      }
	      else
	      {
	    	  System.out.println("All test cases are not executed succesfully");
	      }
		
	}

}
