/**
* This service implementation calculates fibonacci series
* and returns the output for positive input.
* For negative input it throws error message.
* Here the fibonacci calculation is limited to N number 93
*
* @author  Usha Rani
* @version 1.0
* @since   2014-03-25 
*/
package com.app.impl;

public class SeriesImpl {

	public String getFibonacci(int fibonacciElements) throws IllegalArgumentException
	{
		String series = "";
		if(fibonacciElements >= 0 && fibonacciElements < 94)
    	{
			//By default fibonacci has first 2 number 0 & 1
			int firstNumber = 0;
			int secondNumber = 1;
			int result = 0;
			
			for (int counter=0; counter < fibonacciElements; counter++)
			{
				
				if (counter < 2)
				{
					series = series+" "+counter;
				}
				else
				{
					//Here adding the first number and second number and swapping the second number to the first 
					//and the new result to the second number.
					result = firstNumber + secondNumber;
					series = series+" "+result;
					
					firstNumber = secondNumber;
					secondNumber = result;
					
				}
				
			}
			 
    	}
		else if( fibonacciElements < 0)
		{
			throw new IllegalArgumentException("Input must be a positive value");
		}
		
		else
		{
			throw new IllegalArgumentException("Input is out of range for Long please provide less than 94");
		}
			 
		 return series;
	}
	
	
}
