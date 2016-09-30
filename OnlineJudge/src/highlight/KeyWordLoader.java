package highlight;

public class KeyWordLoader {
	public Syntax getSyntax(String fileName) {
		Syntax syntax = new Syntax();
		XMLParser parser = new XMLParser();
		try {
			syntax.setKeyWords(parser.parse(fileName, "keyWords"));
		} catch (Exception e) {
			System.out.println("In KeyWordLoader() " + e);
		}
		
		return syntax;
	}
}
