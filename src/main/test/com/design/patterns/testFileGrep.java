package com.design.patterns;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.*;

@RunWith(Parameterized.class)
public class testFileGrep {

	private FileGrep filegrep;
	private FileGrep get;//change made
	private String searchWord;
	private String line;
	private String inputline;//change made
	private String findword;//change made
	private String multiline;
	private int expectedresult;
	ByteArrayOutputStream outputContent;

	/**
	 * This method will run before each test case
	 * 
	 */
	@Before
	public void beforeTest() {
		outputContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputContent));
		filegrep = new FileGrep(searchWord);
		get = new FileGrep(findword);//change made
	}

	@After
	public void afterTest() {
		outputContent = null;
		filegrep = null;
		get = null;//change made
	}

	public testFileGrep(String line, String searchword, String multiline, int expectedresult, String inputline, String findword) {
		// TODO Auto-generated constructor stub
		this.line = line;
		this.searchWord = searchword;
		this.multiline = multiline;
		this.expectedresult = expectedresult;
		this.inputline = inputline;
		this.findword = findword;
	}

	/**
	 * I am returning 4 parameters so that i can test different scenarios
	 * Parameter 1 - 
	 */
	@Parameterized.Parameters
	public static Collection wordcountcoll() {
		return Arrays.asList(new Object[][] {
				{ "This is a test line one", "test",
						"This is test for multiple lines 1\r\n" + "This is test for multiple lines 2\r\n"
								+ "This is test for multiple lines 3\r\n" + "\r\n" + "",
						3,"The way is too long","short" },
				{ "This is a test line line line two", "line", "This is test for multiple lines 1\r\n"
						+ "This is test for multiple lines 2\r\n" + "\r\n" + "\r\n" + "", 2,"My name is Henry","Peter" } });
	}

	/**
	 * Test to check if single line is getting printed for grep
	 * 
	 * @throws IOException
	 */

	@Test
	public void testSearchWord() throws IOException {
		filegrep.processWords(line);
		assertEquals(line, outputContent.toString());
	}

	//change made : have defined test case for scenario when word is not found during search
	@Test
	public void testSearchWordnotfound() throws IOException {
		get.processWords(inputline);
		assertNotEquals(inputline, outputContent.toString());
	}
	/**
	 * Test case to check if multiple lines are printing
	 * 
	 * @throws IOException
	 */
	@Test
	public void testMultipleLines() throws IOException {
		filegrep.processWords(multiline);
		assertEquals(expectedresult, filegrep.lineCount);

	}
}
