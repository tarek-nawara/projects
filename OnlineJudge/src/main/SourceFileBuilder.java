package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class SourceFileBuilder {

	private File sourceFile = null;

	public void build(String fileName, String language) throws Exception {
		InputStream inputStream = new FileInputStream(fileName);
		String outFileExtension;
		if (language.equals("java")) {
			outFileExtension = ".java";
		} else if (language.equals("c")) {
			outFileExtension = ".c";
		} else if (language.equals("python")) {
			outFileExtension = ".py";
		} else if (language.equals("ruby")) {
			outFileExtension = ".rb";
		} else {
			outFileExtension = ".cpp";
		}
		sourceFile = new File("Main" + outFileExtension);
		OutputStream outputStream = new FileOutputStream(sourceFile);
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		PrintWriter out = new PrintWriter(outputStream);

		String line;
		while ((line = reader.readLine()) != null) {
			out.println(line);
		}
		reader.close();
		out.close();
	}

	public void deleteSourceFile() {
		if (sourceFile.delete()) {
			System.out.println("Source File Deleted");
		} else {
			System.out.println("Failed to delete source file");
		}
	}
}
