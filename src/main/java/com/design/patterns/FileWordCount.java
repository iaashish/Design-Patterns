package com.design.patterns;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class FileWordCount implements FileInterface {

	int lineCount;
	int wordCount;
	int characterCount;
	String[] lineArray = null;

	FileWordCount() {
		lineCount = 0;
		wordCount = 0;
		characterCount = 0;

	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("done wc");
		System.out.println("lines : " + lineCount);
		System.out.println("words : " + wordCount);
		System.out.println("Characters : " + characterCount);
	}

	@Override
	public void processLine(String line) throws IOException {
		// TODO Auto-generated method stub
		if (line != null && !line.isEmpty()) {
			lineCount = lineCount + 1;
			characterCount += line.replaceAll("\\s", "").length();
			lineArray = line.trim().split("\\s");
		}
	}

	@Override
	public void processWords() throws IOException {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		if (lineArray != null) {
			for (String w : lineArray) {
				if (!w.isEmpty()) {
					list.add(w);
				}
			}
		}
		wordCount += list.size();
	}

}
