package com.design.patterns;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileStrategy {

	public static void main(String[] args) throws IOException {
		FileContext fc;
		
		BufferedReader br = null;
		br = new BufferedReader(new InputStreamReader(System.in));
		String operation = "";
		String file = "";
		String word = "";
		while (true) {
			System.out.print(">");

			StringTokenizer tokens = new StringTokenizer(br.readLine());

			if (tokens.countTokens() == 2) {
				operation = tokens.nextToken();
				file = tokens.nextToken();

			} else if (tokens.countTokens() == 3) {
			operation = tokens.nextToken();
			word = tokens.nextToken();
			file = tokens.nextToken();
			} else {

		}
			try {
			if (operation.equalsIgnoreCase("wc")) {
				fc = new FileContext(new FileWordCount());
				fileReader(fc, file);
				fc.displayresult();
			}

			if (operation.equalsIgnoreCase("grep")) {
				fc = new FileContext(new FileGrep(args[1]));
				fileReader(fc, file);
				fc.displayresult();
			}

			if (operation.equalsIgnoreCase("freq")) {
				fc = new FileContext(new FileFreq());
				fileReader(fc, file);
				fc.displayresult();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e);
		}
	}
	}
	// Single to read from the file an pass each line to the required class
	public static void fileReader(FileContext fc, String file) throws IOException {

		try {
			BufferedReader bf = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = bf.readLine()) != null) {
				fc.executeCW(line);
			}
			bf.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
