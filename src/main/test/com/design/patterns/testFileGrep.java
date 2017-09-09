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
	private String searchWord;
	private String line;
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
	}

	@After
	public void afterTest() {
		outputContent = null;
		filegrep = null;
	}

	public testFileGrep(String line, String searchword, String multiline, int expectedresult) {
		// TODO Auto-generated constructor stub
		this.line = line;
		this.searchWord = searchword;
		this.multiline = multiline;
		this.expectedresult = expectedresult;
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
						3 },
				{ "This is a test line line line two", "line", "This is test for multiple lines 1\r\n"
						+ "This is test for multiple lines 2\r\n" + "\r\n" + "\r\n" + "", 2 } });
	}

	/**
	 * Test to check if single line is getting printed for grep
	 * 
	 * @throws IOException
	 */

	@Test
	public void testSearchWord() throws IOException {
		filegrep.processLine(line);
		filegrep.processWords();
		assertEquals(line, outputContent.toString());
	}

	/**
	 * Test case to check if multiple lines are printing
	 * 
	 * @throws IOException
	 */
	@Test
	public void testMultipleLines() throws IOException {
		filegrep.processLine(multiline);
		filegrep.processWords();
		assertEquals(expectedresult, filegrep.lineCount);

	}
}
