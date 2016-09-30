package main;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Executer {

	private File out = null;
	private StringBuilder outputStatus = new StringBuilder();
	
	
	public verdict execute(String language, String outputFile, String inputFile, long timeInMillis) {
		outputStatus.append("Code started executing...");
		ProcessBuilder processBuilder = getProcessBuilder(language);

		processBuilder.directory(new File(System.getProperty("user.dir")));
		File in = new File(inputFile);
		processBuilder.redirectInput(in);

		if (in.exists())
			outputStatus.append("Input file " + in.getAbsolutePath());

		processBuilder.redirectErrorStream(true);
		outputStatus.append("Current directory " + System.getProperty("user.dir"));
		
		out = new File(outputFile);

		processBuilder.redirectOutput(out);
		if (out.exists())
			outputStatus.append("Output file generated " + out.getAbsolutePath());

		try {	
			Process process = processBuilder.start();
			if (!process.waitFor(timeInMillis, TimeUnit.MILLISECONDS)) {
				return verdict.TLE;
			}
			int exitCode = process.exitValue();
			outputStatus.append("Exit Value = " + process.exitValue());
			if (exitCode != 0)
				return verdict.RUN_ERROR;
		} catch (IOException ioe) {
			outputStatus.append("in execute() " + ioe);
		} catch (InterruptedException ex) {
			System.err.println(ex);
		}
		outputStatus.append("Code execution finished!\n");
		return verdict.RUN_SUCCESS;
	}

	public void deleteExecutables(String language) {
		String executeExtension;
		if (language.equals("java")) {
			executeExtension = ".class";
		} else {
			executeExtension = ".exe";
		}
		File exe = new File("Main" + executeExtension);
		if (exe.delete()) {
			System.out.println("executable File deleted");
		} else {
			System.out.println("Failed to delete executable");
		}
	}
	
	public void deleteOutFile() {
		if (out.delete()) {
			outputStatus.append("Output file deleted");
		} else {
			outputStatus.append("Failed to delete output file");
		}
	}
	
	public ProcessBuilder getProcessBuilder(String language) {
		ProcessBuilder processBuilder = null;
		if (language.equals("java")) {
			processBuilder = new ProcessBuilder("java", "Main");
		} else if (language.equals("python")) {
			processBuilder = new ProcessBuilder("python", "Main.py");
		} else if (language.equals("ruby")) {
			processBuilder = new ProcessBuilder("ruby", "Main.rb");
		} else {
			processBuilder = new ProcessBuilder("./Main");
		}
		return processBuilder;
	}
	
	public String getStatus() {
		return outputStatus.toString();
	}
}
