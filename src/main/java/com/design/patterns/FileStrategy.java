package com.design.patterns;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStrategy {

	public static void main(String[] args) throws IOException {
		FileContext fc;

		try {
			if (args[0].equalsIgnoreCase("wc")) {
				fc = new FileContext(new FileWordCount());
				fileReader(fc, args[1]);
				fc.displayresult();
			}

			if (args[0].equalsIgnoreCase("grep")) {
				fc = new FileContext(new FileGrep(args[1]));
				fileReader(fc, args[2]);
				fc.displayresult();
			}

			if (args[0].equalsIgnoreCase("freq")) {
				fc = new FileContext(new FileFreq());
				fileReader(fc, args[1]);
				fc.displayresult();
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Error : " + e);
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
