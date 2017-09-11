package com.design.patterns;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class testFileStrategy {

	/**
	 * This method checks if the file has only single line
	 * 
	 * @throws IOException
	 */
	FileWordCount filewordcount;
	FileContext filecontext;
	private String file;
	private int expectedresult;
	FileStrategy fs;

	@Before
	public void beforeClass() {
		filewordcount = new FileWordCount();
		filecontext = new FileContext(filewordcount);
		fs = new FileStrategy();
	}

	@After
	public void afterTest() {
		filewordcount = null;
		filecontext = null;
	}

	public testFileStrategy(String file, Integer expected) {
		// TODO Auto-generated constructor stub
		this.file = file;
		this.expectedresult = expected;
	}

	@Parameterized.Parameters
	public static Collection fileStrategyColl() {
		return Arrays.asList(new Object[][] { { "testcases\\Singleline.txt", 1 },
				{ "testcases\\EmptyFile.txt", 0 },
				{ "testcases\\OmitEmptyLinesTestCase.txt", 3 } });
	}

	/*
	 * This method will check the filestrategy class with different files
	 * 
	 */
	@Test
	public void testDifferentFiles() throws IOException {
		fs.fileReader(filecontext, file);
		assertEquals(expectedresult, filewordcount.lineCount);
	}
}
