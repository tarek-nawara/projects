package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Matcher {
	public verdict match(String testOut, String out) {
		BufferedReader b1 = null, b2 = null;
		verdict status = null;
		File f1, f2;
		
		try {
			System.out.println("Matching process started...");
			
			f1 = new File(testOut);
			System.out.println("Test output exists? [" + f1.exists() + "] Path=" + f1.getAbsolutePath());
			
			f2 = new File(out);
			System.out.println("Output exists? [" + f2.exists() + "] Path=" + f2.getAbsolutePath());
			
			b1 = new BufferedReader(new FileReader(f1));
			b2 = new BufferedReader(new FileReader(f2));

			ArrayList<String> userOutput = new ArrayList<>();
			ArrayList<String> judgeOutput = new ArrayList<>();
			String temp;
			
			// parsing the user's output
			while ((temp = b2.readLine()) != null) {
				userOutput.add(temp.trim());
			}
			
			// parsing the judge file
			while ((temp = b1.readLine()) != null) {
				judgeOutput.add(temp.trim());
			}
			System.out.println("Matching ended.\n");

			if (judgeOutput.size() != userOutput.size()) {
				status = verdict.WRONG_ANSWER;
			} else {
				boolean correct = true;
				
				for (int i = 0; i < judgeOutput.size(); ++i) {
					if (!judgeOutput.get(i).equals(userOutput.get(i))) {
						correct = false;
						System.out.println("Wrong Answer in test " + (i + 1) + "\n----------------------------------");
						System.out.println("Judge Answer\n" + judgeOutput.get(i) + "\n");
						System.out.println("User Answer\n" + userOutput.get(i) + "\n");
					}
				}
				
				if (correct) {
					status = verdict.ACCEPTED;
				} else {
					status = verdict.WRONG_ANSWER;
				}
			}

		} catch (FileNotFoundException ex) {
			System.err.println("in match() " + ex);
		} catch (IOException ex) {
			System.err.println("in match() " + ex);
		} finally {
			try {
				b1.close();
				b2.close();
			} catch (IOException ex) {
				System.err.println("in match() " + ex);
			}
		}
		return status;
	}
}
