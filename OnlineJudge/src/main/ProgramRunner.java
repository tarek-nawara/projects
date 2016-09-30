package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ProgramRunner {

	private StringBuilder status = new StringBuilder();
	
	public boolean run(String language, String outputFile, String inputFile, String sourceFile, long timeLimit) {
		Set<String> isCompiledLan = new HashSet<>(Arrays.asList("java", "C++", "C"));
		Set<String> isInterpretedLan = new HashSet<>(Arrays.asList("python", "ruby"));

		Executer executer = new Executer();

		if (isCompiledLan.contains(language)) {
			Compiler compiler = new Compiler();
			compiler.compile(language);
			executer.execute(language, outputFile, inputFile, timeLimit);
			
			status.append(compiler.getStatus());
			status.append(executer.getStatus());
		}

		else if (isInterpretedLan.contains(language)) {
			executer.execute(language, outputFile, inputFile, timeLimit);
			status.append(executer.getStatus());
		}

		else {
			return false;
		}
		
		return true;
	}
	
	public String getStatus() {
		return status.toString();
	}
}
