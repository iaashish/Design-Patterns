package com.design.patterns;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class testFileFreq {

	private FileFreq filefreq;
	private String freqLine = null;
	private String freqText = null;
	private String freqTextNotCase = null;
	private int freqTextCount = 0;
	private HashMap<String, Integer> freqMap = new HashMap<>();

	/**
	 * Creating new objects here before the test method is called
	 * 
	 * @throws IOException
	 */
	@Before
	public void beforeClass() throws IOException {
		filefreq = new FileFreq();
		filefreq.processWords(freqLine);

	}

	/**
	 * once test is completed clearing the object
	 * 
	 */
	@After
	public void afterTest() {
		filefreq = null;

	}

	public testFileFreq(String freqLine, Integer freqTextCount, String freqText, String freqTextNotCase) {
		// TODO Auto-generated constructor stub
		this.freqLine = freqLine;
		this.freqTextCount = freqTextCount;
		this.freqText = freqText;
		this.freqTextNotCase = freqTextNotCase;
	}

	/**
	 * 
	 * 
	 * here i am using 5 parameters which is used to test different scenarios for
	 * frequency class
	 * 
	 * 
	 * @return
	 */
	@Parameterized.Parameters
	public static Collection wordcountcoll() {


		return Arrays.asList(new Object[][] { { "This is a test line one", 1, "test", "hello" },
				{ "This is a test line line line two", 3, "line", "Line"} });
	}

	/**
	 * This test is to check the frequency of particular word
	 * 
	 */
	@Test
	public void testWordFreq() {
		assertEquals(freqTextCount, (int) filefreq.frequencies.get(freqText));
	}

	/**
	 * This test is to check if the hashmap contains a particular word
	 * 
	 */

	@Test
	public void testNoWordInMap() {
		assertFalse(filefreq.frequencies.containsKey(freqTextNotCase));
	}

}
