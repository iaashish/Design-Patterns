package com.design.patterns;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWordCount implements FileInterface {

	private int lineCount;
	private int wordCount;
	private int characterCount;
	private String[] lineArray = null;

	FileWordCount() {
		lineCount = 0;
		wordCount = 0;
		characterCount = 0;

	}

	/*
	 * @Override public void processLine(String line) throws IOException { // TODO
	 * Auto-generated method stub
	 * 
	 * if (line != null && !line.isEmpty()) { lineCount = lineCount + 1;
	 * characterCount += line.replaceAll("\\s", "").length(); lineArray =
	 * line.trim().split("\\s"); } }
	 */

	@Override
	public void processWords(String line) throws IOException {
		// TODO Auto-generated method stub
		if (line != null && !line.isEmpty()) {
			lineArray = line.trim().split("\\n");
			lineCount += lineArray.length;
			for (String s : lineArray) {
				characterCount += s.replaceAll("[\\s,?.;'/0-9/]", "").length();
			}
			for (String w : lineArray) {
				String[] w2 = w.replaceAll("[\\s.?,;/0-9/]", " ").split(" ");
				for (String w3 : w2) {
					if (!w3.matches("\\s") && !w3.isEmpty()) {
						wordCount++;
					}
				}

			}
		}
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("done wc");
		System.out.println("lines : " + lineCount);
		System.out.println("words : " + wordCount);
		System.out.println("Characters : " + characterCount);
	}

	public int getLineCount() {
		return lineCount;
	}

	public int getWordCount() {
		return wordCount;
	}

	public int getCharacterCount() {
		return characterCount;
	}

}
