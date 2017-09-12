package com.design.patterns;

import java.io.IOException;

public interface FileInterface {

//	public void processLine(String line) throws IOException;

	public void processWords(String line) throws IOException;

	public void output();
}
