package com.design.patterns;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.*;

@RunWith(Parameterized.class)
public class testFileWordCount {

	/**
	 * To test if words are correctly
	 * 
	 * @throws IOException
	 */
	private FileWordCount filewordcount;
	private String testline = null;
	private int expectedL;// line count
	private int expectedW;// word count
	private int expectedC;// charcater count

	@Before
	public void beforeClass() {
		filewordcount = new FileWordCount();
	}

	public testFileWordCount(String line, int Linelength, int wordLength, int charLength) {
		// TODO Auto-generated constructor stub
		this.testline = line;
		this.expectedL = Linelength;
		this.expectedW = wordLength;
		this.expectedC = charLength;
	}

	/**
	 * 
	 * 
	 * Here i am using 4 parameters for wordcount class testing with different
	 * Scenarios
	 * 
	 * @return
	 */
	@Parameterized.Parameters
	public static Collection wordcountcoll() {
		return Arrays.asList(new Object[][] { { "   This is a   test line one", 1, 6, 18 },
				{ "This is a test line two", 1, 6, 18 }, { "", 0, 0, 0 }, { null, 0, 0, 0 } });

	}

	@Test
	public void testNoOfWords() throws IOException {
		filewordcount.processLine(testline);
		filewordcount.processWords();
		assertEquals(expectedW, filewordcount.wordCount);
	}

	/**
	 * To check if line count is correct
	 * 
	 * @throws IOException
	 * 
	 * 
	 */

	@Test
	public void testNoOfLines() throws IOException {
		filewordcount.processLine(testline);
		assertEquals(expectedL, filewordcount.lineCount);
	}

	/**
	 * Test to count the number of characters excluding white spaces
	 * 
	 * @throws IOException
	 * 
	 */

	@Test
	public void testNoOfCharacters() throws IOException {
		filewordcount.processLine(testline);
		assertEquals(expectedC, filewordcount.characterCount);
	}

}
