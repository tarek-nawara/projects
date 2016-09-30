package highlight;

public class Test {
	public static void main(String[] args) {
		String line = new String("for (int i = 0; i < n; ++i");
		
		KeyWordLoader loader = new KeyWordLoader();
		Syntax syntax = loader.getSyntax("keyWords.xml");
		syntax.highlight(line);
	}
}
