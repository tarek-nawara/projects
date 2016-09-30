package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Compiler {
	
	private StringBuilder outputStatus = new StringBuilder();
	
	public verdict compile(String language) {
		outputStatus.append("Code compilation started...");
		ProcessBuilder processBuilder = getProcessBuilder(language);
		boolean compiled = true;
		
		processBuilder.directory(new File(System.getProperty("user.dir")));
		processBuilder.redirectErrorStream(true);

		try {
			Process process = processBuilder.start();
			InputStream inputStream = process.getInputStream();
			String temp;
			try (BufferedReader b = new BufferedReader(new InputStreamReader(inputStream))) {
				while ((temp = b.readLine()) != null) {
					compiled = false;
					outputStatus.append(temp);
				}
				process.waitFor();
			}

			if (!compiled) {
				inputStream.close();
				return verdict.COMPILE_ERROR;
			}
			inputStream.close();
			return verdict.COMPILE_SUCCESS;

		} catch (IOException | InterruptedException e) {
			outputStatus.append("in compile() " + e);
		}

		return verdict.COMPILE_ERROR;
	}
	
	public ProcessBuilder getProcessBuilder(String language) {
		ProcessBuilder processBuilder = null;
		if (language.equals("java")) {
			processBuilder = new ProcessBuilder("javac", "Main.java");
		} else if (language.equals("c")) {
			processBuilder = new ProcessBuilder("gcc", "-std=c++0x", "-w", "-o", "Main", "Main.c");
		} else {
			processBuilder = new ProcessBuilder("g++", "-std=c++0x", "-w", "-o", "Main", "Main.cpp");
		}
		
		return processBuilder;
	}
	
	public String getStatus() {
		return outputStatus.toString();
	}
}
