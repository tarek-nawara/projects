package highlight;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Syntax {
	Set<String> keyWords = null;

	public void highlight(String line) {
		for (String key : keyWords) {
			Pattern pattern = Pattern.compile("\\s?" + key + "\\s");
			Matcher matcher = pattern.matcher(line);
			while (matcher.find()) {
				if (matcher.group().length() != 0) {
					System.out.println(matcher.group());
					System.out.println("Start at: " + matcher.start());
					System.out.println("End at: " + matcher.end());
				}
			}
		}
	}
	
	public void setKeyWords(Set<String> keyWords) {
		if (keyWords == null)
			return;
		this.keyWords = new HashSet<>();
		this.keyWords.addAll(keyWords);
	}
}