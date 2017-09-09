package com.design.patterns;

import java.io.IOException;
import java.util.HashMap;

public class FileFreq implements FileInterface {

	HashMap<String, Integer> frequencies;
	String[] wordarray = null;

	FileFreq() {
		frequencies = new HashMap<String, Integer>();
	}

	@Override
	public void processLine(String line) throws IOException {
		// TODO Auto-generated method stub
		wordarray = line.trim().split("\\s");
	}

	@Override
	public void processWords() throws IOException {
		// TODO Auto-generated method stub
		for (String word : wordarray) {
			Integer frequency = frequencies.get(word);
			frequencies.put(word, (frequency == null) ? 1 : frequency + 1);
		}
	}

	@Override
	public void output() {
		// TODO Auto-generated method stub
		System.out.println("freq");
		for (String name : frequencies.keySet()) {
			String key = name.toString();
			String value = frequencies.get(name).toString();
			System.out.println(key + " " + value);
		}
	}
}
