package com.inetbanking.userDefined;

public class AssertionMethods {
	
	public static boolean testcasePass = true;
	
	/**
	 * 
	 * @param expectedValue
	 * @param actualValue
	 */
	public static void expectedActualTest(String expectedValue, String actualValue)
	{
		if(!expectedValue.toUpperCase().trim().equals(actualValue.toUpperCase().trim()))
		{
			testcasePass = false;
		}
	}
	
	public static void expectedNotActualTest(String expectedValue, String actualValue)
	{
		if(expectedValue.equals(actualValue))
		{
			testcasePass=false;
		}
	}
	
	

}
