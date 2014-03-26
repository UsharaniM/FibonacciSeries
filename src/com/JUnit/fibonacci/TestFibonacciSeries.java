/**
* This is JUNIT test case class to test the Fibonacci series.
*
* @author  Usha Rani
* @version 1.0
* @since   2014-03-25 
*/
package com.JUnit.fibonacci;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.impl.SeriesImpl;

public class TestFibonacciSeries extends TestCase {
	private int FibonacciElementsLengthForPositive ;
	private int FibonacciElementsLengthForNegative ;
	private int FibonacciElementsLengthasLongNumber ;
	private SeriesImpl seriesImpl = new SeriesImpl();
	/*
	 * @Before this method will be executed before every test case invocation
	 */
	@Before
	public void setup()
	{
		FibonacciElementsLengthForPositive = 60;
		FibonacciElementsLengthForNegative = -3;
		FibonacciElementsLengthasLongNumber = 99;
		
	}
	/*
	 * This method will be executed after every test case.
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown()
	{
		
	}
	/**
	 * Precondition
	 * Element length should be positive value.
	 * expected:
	 * number of elements should be the given input FibonacciElementLength.
	 * element in the fibonacci series should be the sum of the two previous numbers 
	 * 
	 */
	
	@Test
	public void testFibonacciSeries()
	{
		
		String fibonacciSeries = seriesImpl.getFibonacci(FibonacciElementsLengthForPositive);
		String[] fibonacciElements = fibonacciSeries.split(" ");
		// assert if the given input length doesn't match the output elements
		//here checking length -1 as the starting we are taking empty string
		assertFalse("The output fibonacci Elements does not match the input length ", fibonacciElements.length-1 != FibonacciElementsLengthForPositive );
		int fibonacciPreviousElement = 1;
		int fibonacciPreviousSecondElement = 0;
		if(null != fibonacciElements && fibonacciElements.length >=2  )
		{
			assertFalse("Fibonacci Series First element is not zero", new Integer(fibonacciElements[1]).intValue() == fibonacciPreviousElement);
		}
		if(null != fibonacciElements && fibonacciElements.length >=3  )
		{
			assertFalse("Fibonacci Series second element is not 1", new Integer(fibonacciElements[2]).intValue() == fibonacciPreviousSecondElement);
		}
		//fibonacciPreviousSecondElement = fibonacciPreviousSecondElement+fibonacciPreviousElement;
		
		for(int counter =3; counter<fibonacciElements.length;counter++)
		{
			fibonacciPreviousSecondElement = fibonacciPreviousSecondElement+fibonacciPreviousElement;
			assertFalse("Fibonacci Series"+ counter + " element is not correct",new Integer(fibonacciElements[counter]).intValue() == fibonacciPreviousElement+ fibonacciPreviousSecondElement);
			fibonacciPreviousSecondElement = fibonacciPreviousElement;
			fibonacciPreviousElement = new Integer(fibonacciElements[counter]).intValue();
		}
		
	}
	
	/**
	 * Precondition
	 * Element length should be -ve.
	 * expected:
	 * IllegalArgument Exception.
	 * message in the exception should be "Input must be a positive value" 
	 * 
	 */
	@Test(expected = IllegalArgumentException.class) 
	public void testFibonacciSeriesforNegativeNumbers() 
	{
		try
		{
		 seriesImpl.getFibonacci(FibonacciElementsLengthForNegative);
		}
		catch( IllegalArgumentException e)
		{
			assertNotNull("For Negative number IllegalArgumentException is null" , e);
			assertSame("For negative number exception message is not Input must be a positive value", "Input must be a positive value", e.getMessage());
		}

	}
	/**
	 * Precondition
	 * Element length should be > 93.
	 * expected:
	 * IllegalArgument Exception.
	 * message in the exception should be Input is out of range for Long please provide less than 94 
	 * 
	 */
	@Test(expected = IllegalArgumentException.class )
	public void testFibonacciSeriesforLargeNumbers()
	{
		try
		{
			seriesImpl.getFibonacci(FibonacciElementsLengthasLongNumber);
		}
		catch( IllegalArgumentException e)
		{
			assertNotNull("For >93 number IllegalArgumentException is null" , e);
			assertSame("For >93 nuber exception message is not Input is out of range for Long please provide less than 94", "Input is out of range for Long please provide less than 94", e.getMessage());
		}
	}

}
