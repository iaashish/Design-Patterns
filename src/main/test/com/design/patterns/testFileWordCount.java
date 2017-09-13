package com.design.patterns;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
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

	@After
	public void afterClass() {
		filewordcount = null;
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
		return Arrays.asList(new Object[][] { { "This is a test line one\r\n" + "this is onr\r", 2, 9, 27 },
				{ "This is a test line ,,,,,,,,,,;;;;;;;;..........with special characters", 1, 8, 36 },
				{ "There are many variations of passages of Lorem Ipsum available,\n"
						+ " but the majority have suffered alteration in some form,\n" + " by injected humour, \n"
						+ " or randomised words which don't look even slightly believable. \n"
						+ " If you are going to use a passage of Lorem Ipsum,\n"
						+ "  you need to be sure there isn't anything embarrassing hidden in the middle of text.\n"
						+ "  All the Lorem Ipsum generators on the \n"
						+ " Internet tend to repeat predefined chunks as necessary, \n"
						+ " making this the first true generator on the Internet.\n"
						+ "  It uses a dictionary of over 200 Latin words,\n"
						+ " combined with a handful of model sentence structures, \n"
						+ " to generate Lorem Ipsum which looks reasonable.\n"
						+ "  The generated Lorem Ipsum is therefore always free from repetition,\n"
						+ " injected humour, or non-characteristic words etc.", 14, 120, 611 },
				{ "", 0, 0, 0 }, { null, 0, 0, 0 } });

	}

	@Test
	public void testNoOfWords() throws IOException {
		filewordcount.processWords(testline);
		assertEquals(expectedW, filewordcount.getWordCount());
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
		filewordcount.processWords(testline);
		assertEquals(expectedL, filewordcount.getLineCount());
	}

	/**
	 * Test to count the number of characters excluding white spaces
	 * 
	 * @throws IOException
	 * 
	 */

	@Test
	public void testNoOfCharacters() throws IOException {
		filewordcount.processWords(testline);
		assertEquals(expectedC, filewordcount.getCharacterCount());
	}

}
