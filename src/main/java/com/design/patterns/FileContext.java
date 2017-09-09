package com.design.patterns;

import java.io.IOException;

public class FileContext {
	private FileInterface fileInterface;

	public FileContext(FileInterface operations) {
		this.fileInterface = operations;
	}

	// this function will display the output to console
	public void displayresult() {
		fileInterface.output();
	}

	public void executePW(String line) throws IOException {
		fileInterface.processLine(line);
	}

	public void executeCW() throws IOException {
		fileInterface.processWords();
	}
}
