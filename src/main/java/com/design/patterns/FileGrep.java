package com.design.patterns;

import java.io.IOException;
import java.util.Arrays;

public class FileGrep implements FileInterface {

	String searchword = null;
	String Sline = null;
	String[] lineArray = null;
	int lineCount = 0;

	FileGrep(String word) {
		searchword = word;
		// TODO Auto-generated constructor stub
	}

/*	@Override
	public void processLine(String line) throws IOException {
		// TODO Auto-generated method stub
		Sline = line;
		lineArray = line.trim().split("\\n");
	}*/

	@Override
	public void processWords(String line) throws IOException {
		// TODO Auto-generated method stub
		lineArray = line.trim().split("\\n");
		for (String grepLine : lineArray) {
			if (grepLine.contains(searchword)) {
				lineCount++;
				System.out.print(grepLine);
			}
		}
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("done grep");
	}
}
